package org.spring.springboot.domain.yldres.func;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 10:55
 */
public class FuncBundleVersionLogVO {
    /**
     * 自增主鍵
     */
    private Long id;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能编号
     */
    private Long idx;

    /**
     * 功能文件夹
     */
    private String folder;
    /**
     * 功能路径
     */
    private String path;
    /**
     * 功能版本号
     */
    private String version;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
