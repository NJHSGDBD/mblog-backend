package st.coo.memo.service.resource;

import cn.hutool.core.io.file.FileNameUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

import org.springframework.stereotype.Component;
import st.coo.memo.dto.resource.UploadResourceResponse;
import st.coo.memo.entity.TResource;

@Component
@Slf4j
public class LocalResourceProvider implements ResourceProvider {


    @Override
    public UploadResourceResponse upload(String filePath, String publicId) {
        UploadResourceResponse response = new UploadResourceResponse();
        response.setUrl("/api/resource/" + publicId);
        response.setPublicId(publicId);
        response.setSuffix("");
        return response;
    }

    @Override
    public void del(TResource tResource){
        deleteFile(tResource.getInternalPath());
    }


    public void deleteFile(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("文件已成功删除：" + filePath);
            } else {
                System.out.println("无法删除文件：" + filePath);
            }
        } else {
            System.out.println("文件不存在：" + filePath);
        }
    }
}
