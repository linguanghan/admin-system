package org.spring.springboot.domain.game;

import java.io.Serializable;

/**
 * player
 * @author 
 */
public class Player implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 玩家账号ID
     */
    private Long accountid;

    /**
     * 服务器id
     */
    private Integer sid;

    /**
     * 玩家名称/昵称
     */
    private String name;

    /**
     * 头像
     */
    private Integer icon;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像url地址
     */
    private String headimageurl;

    /**
     * 账号创建时间毫秒
     */
    private Long createtime;

    /**
     * 等级
     */
    private Integer lv;

    /**
     * gm权限
     */
    private Integer gmlevel;

    /**
     * vip等级
     */
    private Integer viplevel;

    /**
     * vip经验
     */
    private Integer vipexp;

    /**
     * 累计充值, 统计玩家充值RMB
     */
    private Integer totalrecharge;

    /**
     * 钻石
     */
    private Integer crystal;

    /**
     * 游戏币
     */
    private Integer gold;

    /**
     * 房卡数量
     */
    private Integer roomcard;

    /**
     * 闪电卷
     */
    private Integer fastcard;

    /**
     * 作弊次数
     */
    private Integer cheattimes;

    /**
     * 禁言过期时间
     */
    private Integer bannedChatexpiredtime;

    /**
     * 禁登过期时间
     */
    private Integer bannedLoginexpiredtime;

    /**
     * 封号次数
     */
    private Integer bannedtimes;

    /**
     * 最近一次登陆時間
     */
    private Integer lastlogin;

    /**
     * 最近一次登出時間
     */
    private Integer lastlogout;

    /**
     * 当前的游戏类型
     */
    private Integer currentgametype;

    /**
     * 推荐人
     */
    private Integer referer;

    /**
     * 工会ID
     */
    private Long familyid;

    /**
     * 一级代理ID
     */
    private Integer onelevelAgentsId;

    /**
     * 顶级代理ID
     */
    private Integer topAgentsId;

    /**
     * 真实名字
     */
    private String realname;

    /**
     * 真实号码
     */
    private String realnumber;

    /**
     * zle后台房卡数量
     */
    private Integer zleroomcard;

    /**
     * 直接推荐人
     */
    private Integer realReferer;

    /**
     * 微信ID
     */
    private String wxUnionid;

    private Integer fake;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadimageurl() {
        return headimageurl;
    }

    public void setHeadimageurl(String headimageurl) {
        this.headimageurl = headimageurl;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public Integer getGmlevel() {
        return gmlevel;
    }

    public void setGmlevel(Integer gmlevel) {
        this.gmlevel = gmlevel;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public Integer getVipexp() {
        return vipexp;
    }

    public void setVipexp(Integer vipexp) {
        this.vipexp = vipexp;
    }

    public Integer getTotalrecharge() {
        return totalrecharge;
    }

    public void setTotalrecharge(Integer totalrecharge) {
        this.totalrecharge = totalrecharge;
    }

    public Integer getCrystal() {
        return crystal;
    }

    public void setCrystal(Integer crystal) {
        this.crystal = crystal;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getRoomcard() {
        return roomcard;
    }

    public void setRoomcard(Integer roomcard) {
        this.roomcard = roomcard;
    }

    public Integer getFastcard() {
        return fastcard;
    }

    public void setFastcard(Integer fastcard) {
        this.fastcard = fastcard;
    }

    public Integer getCheattimes() {
        return cheattimes;
    }

    public void setCheattimes(Integer cheattimes) {
        this.cheattimes = cheattimes;
    }

    public Integer getBannedChatexpiredtime() {
        return bannedChatexpiredtime;
    }

    public void setBannedChatexpiredtime(Integer bannedChatexpiredtime) {
        this.bannedChatexpiredtime = bannedChatexpiredtime;
    }

    public Integer getBannedLoginexpiredtime() {
        return bannedLoginexpiredtime;
    }

    public void setBannedLoginexpiredtime(Integer bannedLoginexpiredtime) {
        this.bannedLoginexpiredtime = bannedLoginexpiredtime;
    }

    public Integer getBannedtimes() {
        return bannedtimes;
    }

    public void setBannedtimes(Integer bannedtimes) {
        this.bannedtimes = bannedtimes;
    }

    public Integer getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Integer lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Integer getLastlogout() {
        return lastlogout;
    }

    public void setLastlogout(Integer lastlogout) {
        this.lastlogout = lastlogout;
    }

    public Integer getCurrentgametype() {
        return currentgametype;
    }

    public void setCurrentgametype(Integer currentgametype) {
        this.currentgametype = currentgametype;
    }

    public Integer getReferer() {
        return referer;
    }

    public void setReferer(Integer referer) {
        this.referer = referer;
    }

    public Long getFamilyid() {
        return familyid;
    }

    public void setFamilyid(Long familyid) {
        this.familyid = familyid;
    }

    public Integer getOnelevelAgentsId() {
        return onelevelAgentsId;
    }

    public void setOnelevelAgentsId(Integer onelevelAgentsId) {
        this.onelevelAgentsId = onelevelAgentsId;
    }

    public Integer getTopAgentsId() {
        return topAgentsId;
    }

    public void setTopAgentsId(Integer topAgentsId) {
        this.topAgentsId = topAgentsId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealnumber() {
        return realnumber;
    }

    public void setRealnumber(String realnumber) {
        this.realnumber = realnumber;
    }

    public Integer getZleroomcard() {
        return zleroomcard;
    }

    public void setZleroomcard(Integer zleroomcard) {
        this.zleroomcard = zleroomcard;
    }

    public Integer getRealReferer() {
        return realReferer;
    }

    public void setRealReferer(Integer realReferer) {
        this.realReferer = realReferer;
    }

    public String getWxUnionid() {
        return wxUnionid;
    }

    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid;
    }

    public Integer getFake() {
        return fake;
    }

    public void setFake(Integer fake) {
        this.fake = fake;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Player other = (Player) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountid() == null ? other.getAccountid() == null : this.getAccountid().equals(other.getAccountid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getHeadimageurl() == null ? other.getHeadimageurl() == null : this.getHeadimageurl().equals(other.getHeadimageurl()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLv() == null ? other.getLv() == null : this.getLv().equals(other.getLv()))
            && (this.getGmlevel() == null ? other.getGmlevel() == null : this.getGmlevel().equals(other.getGmlevel()))
            && (this.getViplevel() == null ? other.getViplevel() == null : this.getViplevel().equals(other.getViplevel()))
            && (this.getVipexp() == null ? other.getVipexp() == null : this.getVipexp().equals(other.getVipexp()))
            && (this.getTotalrecharge() == null ? other.getTotalrecharge() == null : this.getTotalrecharge().equals(other.getTotalrecharge()))
            && (this.getCrystal() == null ? other.getCrystal() == null : this.getCrystal().equals(other.getCrystal()))
            && (this.getGold() == null ? other.getGold() == null : this.getGold().equals(other.getGold()))
            && (this.getRoomcard() == null ? other.getRoomcard() == null : this.getRoomcard().equals(other.getRoomcard()))
            && (this.getFastcard() == null ? other.getFastcard() == null : this.getFastcard().equals(other.getFastcard()))
            && (this.getCheattimes() == null ? other.getCheattimes() == null : this.getCheattimes().equals(other.getCheattimes()))
            && (this.getBannedChatexpiredtime() == null ? other.getBannedChatexpiredtime() == null : this.getBannedChatexpiredtime().equals(other.getBannedChatexpiredtime()))
            && (this.getBannedLoginexpiredtime() == null ? other.getBannedLoginexpiredtime() == null : this.getBannedLoginexpiredtime().equals(other.getBannedLoginexpiredtime()))
            && (this.getBannedtimes() == null ? other.getBannedtimes() == null : this.getBannedtimes().equals(other.getBannedtimes()))
            && (this.getLastlogin() == null ? other.getLastlogin() == null : this.getLastlogin().equals(other.getLastlogin()))
            && (this.getLastlogout() == null ? other.getLastlogout() == null : this.getLastlogout().equals(other.getLastlogout()))
            && (this.getCurrentgametype() == null ? other.getCurrentgametype() == null : this.getCurrentgametype().equals(other.getCurrentgametype()))
            && (this.getReferer() == null ? other.getReferer() == null : this.getReferer().equals(other.getReferer()))
            && (this.getFamilyid() == null ? other.getFamilyid() == null : this.getFamilyid().equals(other.getFamilyid()))
            && (this.getOnelevelAgentsId() == null ? other.getOnelevelAgentsId() == null : this.getOnelevelAgentsId().equals(other.getOnelevelAgentsId()))
            && (this.getTopAgentsId() == null ? other.getTopAgentsId() == null : this.getTopAgentsId().equals(other.getTopAgentsId()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getRealnumber() == null ? other.getRealnumber() == null : this.getRealnumber().equals(other.getRealnumber()))
            && (this.getZleroomcard() == null ? other.getZleroomcard() == null : this.getZleroomcard().equals(other.getZleroomcard()))
            && (this.getRealReferer() == null ? other.getRealReferer() == null : this.getRealReferer().equals(other.getRealReferer()))
            && (this.getWxUnionid() == null ? other.getWxUnionid() == null : this.getWxUnionid().equals(other.getWxUnionid()))
            && (this.getFake() == null ? other.getFake() == null : this.getFake().equals(other.getFake()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountid() == null) ? 0 : getAccountid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getHeadimageurl() == null) ? 0 : getHeadimageurl().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLv() == null) ? 0 : getLv().hashCode());
        result = prime * result + ((getGmlevel() == null) ? 0 : getGmlevel().hashCode());
        result = prime * result + ((getViplevel() == null) ? 0 : getViplevel().hashCode());
        result = prime * result + ((getVipexp() == null) ? 0 : getVipexp().hashCode());
        result = prime * result + ((getTotalrecharge() == null) ? 0 : getTotalrecharge().hashCode());
        result = prime * result + ((getCrystal() == null) ? 0 : getCrystal().hashCode());
        result = prime * result + ((getGold() == null) ? 0 : getGold().hashCode());
        result = prime * result + ((getRoomcard() == null) ? 0 : getRoomcard().hashCode());
        result = prime * result + ((getFastcard() == null) ? 0 : getFastcard().hashCode());
        result = prime * result + ((getCheattimes() == null) ? 0 : getCheattimes().hashCode());
        result = prime * result + ((getBannedChatexpiredtime() == null) ? 0 : getBannedChatexpiredtime().hashCode());
        result = prime * result + ((getBannedLoginexpiredtime() == null) ? 0 : getBannedLoginexpiredtime().hashCode());
        result = prime * result + ((getBannedtimes() == null) ? 0 : getBannedtimes().hashCode());
        result = prime * result + ((getLastlogin() == null) ? 0 : getLastlogin().hashCode());
        result = prime * result + ((getLastlogout() == null) ? 0 : getLastlogout().hashCode());
        result = prime * result + ((getCurrentgametype() == null) ? 0 : getCurrentgametype().hashCode());
        result = prime * result + ((getReferer() == null) ? 0 : getReferer().hashCode());
        result = prime * result + ((getFamilyid() == null) ? 0 : getFamilyid().hashCode());
        result = prime * result + ((getOnelevelAgentsId() == null) ? 0 : getOnelevelAgentsId().hashCode());
        result = prime * result + ((getTopAgentsId() == null) ? 0 : getTopAgentsId().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getRealnumber() == null) ? 0 : getRealnumber().hashCode());
        result = prime * result + ((getZleroomcard() == null) ? 0 : getZleroomcard().hashCode());
        result = prime * result + ((getRealReferer() == null) ? 0 : getRealReferer().hashCode());
        result = prime * result + ((getWxUnionid() == null) ? 0 : getWxUnionid().hashCode());
        result = prime * result + ((getFake() == null) ? 0 : getFake().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountid=").append(accountid);
        sb.append(", sid=").append(sid);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", sex=").append(sex);
        sb.append(", headimageurl=").append(headimageurl);
        sb.append(", createtime=").append(createtime);
        sb.append(", lv=").append(lv);
        sb.append(", gmlevel=").append(gmlevel);
        sb.append(", viplevel=").append(viplevel);
        sb.append(", vipexp=").append(vipexp);
        sb.append(", totalrecharge=").append(totalrecharge);
        sb.append(", crystal=").append(crystal);
        sb.append(", gold=").append(gold);
        sb.append(", roomcard=").append(roomcard);
        sb.append(", fastcard=").append(fastcard);
        sb.append(", cheattimes=").append(cheattimes);
        sb.append(", bannedChatexpiredtime=").append(bannedChatexpiredtime);
        sb.append(", bannedLoginexpiredtime=").append(bannedLoginexpiredtime);
        sb.append(", bannedtimes=").append(bannedtimes);
        sb.append(", lastlogin=").append(lastlogin);
        sb.append(", lastlogout=").append(lastlogout);
        sb.append(", currentgametype=").append(currentgametype);
        sb.append(", referer=").append(referer);
        sb.append(", familyid=").append(familyid);
        sb.append(", onelevelAgentsId=").append(onelevelAgentsId);
        sb.append(", topAgentsId=").append(topAgentsId);
        sb.append(", realname=").append(realname);
        sb.append(", realnumber=").append(realnumber);
        sb.append(", zleroomcard=").append(zleroomcard);
        sb.append(", realReferer=").append(realReferer);
        sb.append(", wxUnionid=").append(wxUnionid);
        sb.append(", fake=").append(fake);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}