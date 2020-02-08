package cn.clownmask.common.vo;

import lombok.Data;

/**
 */
@Data
public class UploadResponse {

    private String fileName;
    private String originalFileName;
    private Long size;
    private String type;
    private String url;
    private Integer status;
    private String msg;

    public UploadResponse(String fileName, String originalFileName, String type, String url, Integer status) {
        this.fileName = fileName;
        this.originalFileName = originalFileName;
        this.type = type;
        this.url = url;
        this.status = status;
    }

    public UploadResponse(String originalFileName, Integer status, String msg) {
        this.originalFileName = originalFileName;
        this.status = status;
        this.msg = msg;
    }

    public static final class Error {
        public static final String NONE = "None";
        public static final String OVERSIZE = "File Size largger than the maximum";
        public static final String ILLEGALEXTENSION = "Unsupported file type";
        public static final String FILENOTFOUND = "FileNotFound";

        private Error() {
        }
    }
}
