package org.spring.springboot.domain.yldres;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 22:32
 */
public class Bookresource {
    /**
     * 自增主键
     */
    private Long id;

    private Long bookId;
    private String name;
//    private Boolean release;
//    private Boolean video;
    private Integer release;
    private Integer video;
    private String version;
    private String serverAddress;
    private Integer bookType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelease() {
        return release;
    }

    public void setRelease(Integer release) {
        this.release = release;
    }

    public Integer getVideo() {
        return video;
    }

    public void setVideo(Integer video) {
        this.video = video;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    @Override
    public String toString() {
        return "Bookresource{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", name='" + name + '\'' +
                ", release=" + release +
                ", video=" + video +
                ", version='" + version + '\'' +
                ", bookType='" + bookType + '\'' +
                ", serverAddress='" + serverAddress + '\'' +
                '}';
    }
}
