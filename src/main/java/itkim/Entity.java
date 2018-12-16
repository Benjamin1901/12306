package itkim;

/**
 * @description: TODO
 * @author: KimJun
 * @date: 07/12/18 16:27
 */
public class Entity {
    //车次
    private String TrainNo;

    //发车站
    private String StartStation;

    //目的站
    private String DestStation;

    //发车时间
    private String StartTime;

    //到达时间
    private String ArrTime;

    //总共时间
    private String AllTime;

    //是否可以购买
    private String CanBuy;

    //发车日期
    private String StartDate;

    //软卧
    private String SolfSleep;

    //硬座
    private String HardSeat;

    //无座
    private String NoSeat;

    //硬卧
    private String HardSleep;


    public String getTrainNo() {
        return TrainNo;
    }

    public void setTrainNo(String trainNo) {
        TrainNo = trainNo;
    }

    public String getStartStation() {
        return StartStation;
    }

    public void setStartStation(String startStation) {
        StartStation = startStation;
    }

    public String getDestStation() {
        return DestStation;
    }

    public void setDestStation(String destStation) {
        DestStation = destStation;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getArrTime() {
        return ArrTime;
    }

    public void setArrTime(String arrTime) {
        ArrTime = arrTime;
    }

    public String getAllTime() {
        return AllTime;
    }

    public void setAllTime(String allTime) {
        AllTime = allTime;
    }

    public String getCanBuy() {
        return CanBuy;
    }

    public void setCanBuy(String canBuy) {
        CanBuy = canBuy;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getSolfSleep() {
        return SolfSleep;
    }

    public void setSolfSleep(String solfSleep) {
        SolfSleep = solfSleep;
    }

    public String getHardSeat() {
        return HardSeat;
    }

    public void setHardSeat(String hardSeat) {
        HardSeat = hardSeat;
    }

    public String getNoSeat() {
        return NoSeat;
    }

    public void setNoSeat(String noSeat) {
        NoSeat = noSeat;
    }

    public String getHardSleep() {
        return HardSleep;
    }

    public void setHardSleep(String hardSleep) {
        HardSleep = hardSleep;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "TrainNo='" + TrainNo + '\'' +
                ", StartStation='" + StartStation + '\'' +
                ", DestStation='" + DestStation + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", ArrTime='" + ArrTime + '\'' +
                ", AllTime='" + AllTime + '\'' +
                ", CanBuy='" + CanBuy + '\'' +
                ", StartDate='" + StartDate + '\'' +
                ", SolfSleep='" + SolfSleep + '\'' +
                ", HardSeat='" + HardSeat + '\'' +
                ", NoSeat='" + NoSeat + '\'' +
                ", HardSleep='" + HardSleep + '\'' +
                '}';
    }
}
