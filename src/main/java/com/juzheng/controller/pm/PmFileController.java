package com.juzheng.controller.pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.juzheng.entity.code.CodeData;
import com.juzheng.entity.pm.PmBase;
import com.juzheng.entity.pm.PmFile;
import com.juzheng.service.pm.PmBaseService;
import com.juzheng.service.pm.PmFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/pmFile")
@Api(value = "项目附件Api")
public class PmFileController {
	
	@Resource
	private PmFileService pmFileService;
	@Resource
	private PmBaseService  pmBaseService;
	
	@Value("${upload}")
    private String path;
	 //调用日记文件
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


	  //文件上传相关代码
    @ApiOperation(value="上传附件")
    @RequestMapping(value = "upload", method= RequestMethod.POST)
    public CodeData upload(@RequestParam("file") MultipartFile file,@ApiParam("项目ID") @RequestParam(required=false) Integer pmId,
    		@ApiParam("用户类型") @RequestParam Integer type) {
        if (file.isEmpty()) {
            return new CodeData(500,"文件为空",null);
            
        }
        
        PmFile pmFile=new PmFile();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        pmFile.setfName(fileName);
        
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
 //       System.out.println("filePath"+filePath);
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
//        File f = new File(filePath + "/uploads/");
//        //判断上传文件的保存目录是否存在
//        if (!f.exists() && !f.isDirectory()) {
//            f.mkdirs();
//        }
     //   File dest = new File(filePath +fileName);
        String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int findmaxId = pmFileService.findmaxId();
        fileName=(findmaxId+1)+fileName;
        String str=path+File.separator+nowday+File.separator +fileName;
        File dest = new File(str);
        System.out.println("dest"+dest);
      
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        pmFile.setfPath(str);
        pmFile.setfBelong(type);
        pmFile.setfTime(new Date());
        pmFile.setPmId(pmId);
        pmFileService.insert(pmFile);
        try {
            file.transferTo(dest);
            
            //上传成功修改项目消息
            if (pmId!=null) {
    			PmBase pmBase=new PmBase();
    			pmBase.setPmId(pmId);
    			pmBase.setPmInfo(type);
    			pmBaseService.update(pmBase);
    		}
            
        return new CodeData(1000,"上传成功",pmFile.getId());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return new CodeData(500,"上传失败",null);
    }

    
    
    
    @ApiOperation(value="下载附件")
    @RequestMapping(value = "download", method= RequestMethod.GET)
    public String downLoad(HttpServletResponse response,@ApiParam("附件ID") @RequestParam Integer id){
    	PmFile pmFile=new PmFile();
		pmFile.setId(id);
		List<PmFile> select = pmFileService.select(pmFile);
		PmFile pmFile2 = select.get(0);
		
		
        String filename=pmFile2.getfName();
        String filePath = pmFile2.getfPath() ;
        File file = new File(filePath );
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.err.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    
    @ApiOperation(value = "删除附件", notes = "附件Id必传")
	@RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public Object delete( @ApiParam("附件ID") @RequestParam Integer id) {
		logger.info("删除附件，附件Id={}.", id);
		PmFile pmFile=new PmFile();
		pmFile.setId(id);
		List<PmFile> select = pmFileService.select(pmFile);
		PmFile pmFile2 = select.get(0);
		pmFileService.deleteByPrimaryKey(pmFile2.getId());

		String url = pmFile2.getfPath();
		File file = new File(url);
		if (file.exists()) {
			file.delete();
		}

		return new CodeData(1000, "删除项目附件成功", null);

	}
    
    
    
    @ApiOperation(value = "根据项目id获取附件列表", notes = "项目Id必传")
   	@RequestMapping(value = "/findList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
   	public Object findList( @ApiParam("附件ID") @RequestParam Integer pmId,@ApiParam("附件归属(1-主管单位,2-责任单位)") @RequestParam Integer fBelong) {
   		logger.info("获取附件列表，项目Id={}.", pmId);
   		PmFile pmFile=new PmFile();
   		pmFile.setPmId(pmId);
   		pmFile.setfBelong(fBelong);
   		List<PmFile> select = pmFileService.select(pmFile);
 
   		return new CodeData(1000, "获取项目附件成功", select);

   	}
    
    
	
}
