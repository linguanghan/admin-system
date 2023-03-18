package org.spring.springboot.domain.game;

import java.io.Serializable;

/**
 * playerUnit
 * @author 
 */
public class Playerunit implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long pid;

    /**
     * 创建时间
     */
    private Integer createtime;

    private Integer channel;

    /**
     * 包编号
     */
    private Integer packageidx;

    private Integer bookidx;

    /**
     * 书本类型
     */
    private Integer booktype;

    private Integer unit1;

    private Integer unit2;

    private Integer unit3;

    private Integer unit4;

    private Integer unit5;

    private Integer unit6;

    private Integer unit7;

    private Integer unit8;

    /**
     * 单元9
     */
    private Integer unit9;

    /**
     * 单元10
     */
    private Integer unit10;

    /**
     * 单元11
     */
    private Integer unit11;

    /**
     * 单元12
     */
    private Integer unit12;

    /**
     * 单元13
     */
    private Integer unit13;

    /**
     * 单元14
     */
    private Integer unit14;

    /**
     * 单元15
     */
    private Integer unit15;

    /**
     * 单元16
     */
    private Integer unit16;

    /**
     * 单元17
     */
    private Integer unit17;

    /**
     * 单元18
     */
    private Integer unit18;

    /**
     * 单元19
     */
    private Integer unit19;

    /**
     * 单元20
     */
    private Integer unit20;

    /**
     * 有效期
     */
    private Integer period;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getPackageidx() {
        return packageidx;
    }

    public void setPackageidx(Integer packageidx) {
        this.packageidx = packageidx;
    }

    public Integer getBookidx() {
        return bookidx;
    }

    public void setBookidx(Integer bookidx) {
        this.bookidx = bookidx;
    }

    public Integer getBooktype() {
        return booktype;
    }

    public void setBooktype(Integer booktype) {
        this.booktype = booktype;
    }

    public Integer getUnit1() {
        return unit1;
    }

    public void setUnit1(Integer unit1) {
        this.unit1 = unit1;
    }

    public Integer getUnit2() {
        return unit2;
    }

    public void setUnit2(Integer unit2) {
        this.unit2 = unit2;
    }

    public Integer getUnit3() {
        return unit3;
    }

    public void setUnit3(Integer unit3) {
        this.unit3 = unit3;
    }

    public Integer getUnit4() {
        return unit4;
    }

    public void setUnit4(Integer unit4) {
        this.unit4 = unit4;
    }

    public Integer getUnit5() {
        return unit5;
    }

    public void setUnit5(Integer unit5) {
        this.unit5 = unit5;
    }

    public Integer getUnit6() {
        return unit6;
    }

    public void setUnit6(Integer unit6) {
        this.unit6 = unit6;
    }

    public Integer getUnit7() {
        return unit7;
    }

    public void setUnit7(Integer unit7) {
        this.unit7 = unit7;
    }

    public Integer getUnit8() {
        return unit8;
    }

    public void setUnit8(Integer unit8) {
        this.unit8 = unit8;
    }

    public Integer getUnit9() {
        return unit9;
    }

    public void setUnit9(Integer unit9) {
        this.unit9 = unit9;
    }

    public Integer getUnit10() {
        return unit10;
    }

    public void setUnit10(Integer unit10) {
        this.unit10 = unit10;
    }

    public Integer getUnit11() {
        return unit11;
    }

    public void setUnit11(Integer unit11) {
        this.unit11 = unit11;
    }

    public Integer getUnit12() {
        return unit12;
    }

    public void setUnit12(Integer unit12) {
        this.unit12 = unit12;
    }

    public Integer getUnit13() {
        return unit13;
    }

    public void setUnit13(Integer unit13) {
        this.unit13 = unit13;
    }

    public Integer getUnit14() {
        return unit14;
    }

    public void setUnit14(Integer unit14) {
        this.unit14 = unit14;
    }

    public Integer getUnit15() {
        return unit15;
    }

    public void setUnit15(Integer unit15) {
        this.unit15 = unit15;
    }

    public Integer getUnit16() {
        return unit16;
    }

    public void setUnit16(Integer unit16) {
        this.unit16 = unit16;
    }

    public Integer getUnit17() {
        return unit17;
    }

    public void setUnit17(Integer unit17) {
        this.unit17 = unit17;
    }

    public Integer getUnit18() {
        return unit18;
    }

    public void setUnit18(Integer unit18) {
        this.unit18 = unit18;
    }

    public Integer getUnit19() {
        return unit19;
    }

    public void setUnit19(Integer unit19) {
        this.unit19 = unit19;
    }

    public Integer getUnit20() {
        return unit20;
    }

    public void setUnit20(Integer unit20) {
        this.unit20 = unit20;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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
        Playerunit other = (Playerunit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getPackageidx() == null ? other.getPackageidx() == null : this.getPackageidx().equals(other.getPackageidx()))
            && (this.getBookidx() == null ? other.getBookidx() == null : this.getBookidx().equals(other.getBookidx()))
            && (this.getBooktype() == null ? other.getBooktype() == null : this.getBooktype().equals(other.getBooktype()))
            && (this.getUnit1() == null ? other.getUnit1() == null : this.getUnit1().equals(other.getUnit1()))
            && (this.getUnit2() == null ? other.getUnit2() == null : this.getUnit2().equals(other.getUnit2()))
            && (this.getUnit3() == null ? other.getUnit3() == null : this.getUnit3().equals(other.getUnit3()))
            && (this.getUnit4() == null ? other.getUnit4() == null : this.getUnit4().equals(other.getUnit4()))
            && (this.getUnit5() == null ? other.getUnit5() == null : this.getUnit5().equals(other.getUnit5()))
            && (this.getUnit6() == null ? other.getUnit6() == null : this.getUnit6().equals(other.getUnit6()))
            && (this.getUnit7() == null ? other.getUnit7() == null : this.getUnit7().equals(other.getUnit7()))
            && (this.getUnit8() == null ? other.getUnit8() == null : this.getUnit8().equals(other.getUnit8()))
            && (this.getUnit9() == null ? other.getUnit9() == null : this.getUnit9().equals(other.getUnit9()))
            && (this.getUnit10() == null ? other.getUnit10() == null : this.getUnit10().equals(other.getUnit10()))
            && (this.getUnit11() == null ? other.getUnit11() == null : this.getUnit11().equals(other.getUnit11()))
            && (this.getUnit12() == null ? other.getUnit12() == null : this.getUnit12().equals(other.getUnit12()))
            && (this.getUnit13() == null ? other.getUnit13() == null : this.getUnit13().equals(other.getUnit13()))
            && (this.getUnit14() == null ? other.getUnit14() == null : this.getUnit14().equals(other.getUnit14()))
            && (this.getUnit15() == null ? other.getUnit15() == null : this.getUnit15().equals(other.getUnit15()))
            && (this.getUnit16() == null ? other.getUnit16() == null : this.getUnit16().equals(other.getUnit16()))
            && (this.getUnit17() == null ? other.getUnit17() == null : this.getUnit17().equals(other.getUnit17()))
            && (this.getUnit18() == null ? other.getUnit18() == null : this.getUnit18().equals(other.getUnit18()))
            && (this.getUnit19() == null ? other.getUnit19() == null : this.getUnit19().equals(other.getUnit19()))
            && (this.getUnit20() == null ? other.getUnit20() == null : this.getUnit20().equals(other.getUnit20()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getPackageidx() == null) ? 0 : getPackageidx().hashCode());
        result = prime * result + ((getBookidx() == null) ? 0 : getBookidx().hashCode());
        result = prime * result + ((getBooktype() == null) ? 0 : getBooktype().hashCode());
        result = prime * result + ((getUnit1() == null) ? 0 : getUnit1().hashCode());
        result = prime * result + ((getUnit2() == null) ? 0 : getUnit2().hashCode());
        result = prime * result + ((getUnit3() == null) ? 0 : getUnit3().hashCode());
        result = prime * result + ((getUnit4() == null) ? 0 : getUnit4().hashCode());
        result = prime * result + ((getUnit5() == null) ? 0 : getUnit5().hashCode());
        result = prime * result + ((getUnit6() == null) ? 0 : getUnit6().hashCode());
        result = prime * result + ((getUnit7() == null) ? 0 : getUnit7().hashCode());
        result = prime * result + ((getUnit8() == null) ? 0 : getUnit8().hashCode());
        result = prime * result + ((getUnit9() == null) ? 0 : getUnit9().hashCode());
        result = prime * result + ((getUnit10() == null) ? 0 : getUnit10().hashCode());
        result = prime * result + ((getUnit11() == null) ? 0 : getUnit11().hashCode());
        result = prime * result + ((getUnit12() == null) ? 0 : getUnit12().hashCode());
        result = prime * result + ((getUnit13() == null) ? 0 : getUnit13().hashCode());
        result = prime * result + ((getUnit14() == null) ? 0 : getUnit14().hashCode());
        result = prime * result + ((getUnit15() == null) ? 0 : getUnit15().hashCode());
        result = prime * result + ((getUnit16() == null) ? 0 : getUnit16().hashCode());
        result = prime * result + ((getUnit17() == null) ? 0 : getUnit17().hashCode());
        result = prime * result + ((getUnit18() == null) ? 0 : getUnit18().hashCode());
        result = prime * result + ((getUnit19() == null) ? 0 : getUnit19().hashCode());
        result = prime * result + ((getUnit20() == null) ? 0 : getUnit20().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", createtime=").append(createtime);
        sb.append(", channel=").append(channel);
        sb.append(", packageidx=").append(packageidx);
        sb.append(", bookidx=").append(bookidx);
        sb.append(", booktype=").append(booktype);
        sb.append(", unit1=").append(unit1);
        sb.append(", unit2=").append(unit2);
        sb.append(", unit3=").append(unit3);
        sb.append(", unit4=").append(unit4);
        sb.append(", unit5=").append(unit5);
        sb.append(", unit6=").append(unit6);
        sb.append(", unit7=").append(unit7);
        sb.append(", unit8=").append(unit8);
        sb.append(", unit9=").append(unit9);
        sb.append(", unit10=").append(unit10);
        sb.append(", unit11=").append(unit11);
        sb.append(", unit12=").append(unit12);
        sb.append(", unit13=").append(unit13);
        sb.append(", unit14=").append(unit14);
        sb.append(", unit15=").append(unit15);
        sb.append(", unit16=").append(unit16);
        sb.append(", unit17=").append(unit17);
        sb.append(", unit18=").append(unit18);
        sb.append(", unit19=").append(unit19);
        sb.append(", unit20=").append(unit20);
        sb.append(", period=").append(period);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}