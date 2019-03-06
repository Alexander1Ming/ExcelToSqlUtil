package com.github.sd4324530.fastexcel;

import com.github.sd4324530.fastexcel.entity.Crossing;
import com.github.sd4324530.fastexcel.entity.MyTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class ExcelSqlReader {
    List<String> sqls = new ArrayList<String>();
    String path = "I:/sc/CompanyProject/6 FastExcel/insert.txt";
    private static final Logger LOG = LoggerFactory.getLogger(ExcelSqlReader.class);
    @Test
    public void test() {
        try {
            createExcel();
            writeToTxt();
        } catch (IOException e) {
            LOG.error("异常", e);
        } catch (InvalidFormatException e) {
            LOG.error("异常", e);
        }
    }

    private void createExcel() throws IOException, InvalidFormatException {
        FastExcel fastExcel = new FastExcel("I:/sc/CompanyProject/6 FastExcel/data.xlsx");
        fastExcel.setSheetName("日照信号机点位表");
        List<Crossing> crossings = fastExcel.parse(Crossing.class);
        int deviceID = 90001;

        if (null != crossings && !crossings.isEmpty()) {
            for (Crossing crossing : crossings) {
                if (crossing.getAddress() == null) {
                    continue;
                }
                if (crossing.getRoadName() == null) {
                    continue;
                }
                if (crossing.getX() == null) {
                    continue;
                }
                if (crossing.getY() == null) {
                    continue;
                }

//                String sql = "update JR_CROSS t set t.districtbrigade = '" +
//                        crossing.getDistrictbrigade() + "' where t.roadid = '" +
//                        crossing.getRoadid() + "' and t.districtbrigade is null ;";

                String sql ="insert into device_all (DEVICEID,DEVICECODE,devicename ,devicesystem ,pointcode ," +
                        "devicestatus , deptcode   ,ip ,MANUFACTURER, MANUFACTURERID  ,MAINTAINER,MAINTAINERID , " +
                        "devtype) values ('";
                sql = sql + Integer.toString(deviceID) + "','";
                sql = sql + Integer.toString(deviceID) + "','";
                sql = sql + crossing.getRoadName() + "','5','";
                sql = sql + crossing.getX() + "," + crossing.getY() + "','1','371100000000' ,'";
                sql = sql + crossing.getAddress() + "','连云港杰瑞电子有限公司', '0001','杰瑞','0001' , '13');";
                sqls.add(sql);
                deviceID = deviceID + 1;
                LOG.debug("记录:{}", crossing.toString());
            }
        } else {
            LOG.debug("没有结果");
        }
        fastExcel.close();
    }

    private void writeToTxt() throws IOException {
        if(null != sqls && !sqls.isEmpty()){
            try {
                File file = new File(path);		//文件路径（路径+文件名）
                if (!file.exists()) {	//文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String sql:sqls) {
                    bw.write(sql + "\n");
                }
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }

}
