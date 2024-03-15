package st.coo.memo.service.resource;

import st.coo.memo.dto.resource.UploadResourceResponse;
import st.coo.memo.entity.TResource;

public interface ResourceProvider {
    UploadResourceResponse upload(String filePath, String publicId);

    void del(TResource tResource);
}