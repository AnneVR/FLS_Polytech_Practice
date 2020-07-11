package com.beta.backend.Models;

import com.beta.backend.Models.Analytics.Analytics;
import com.beta.backend.Models.Dicts.AbstractDictTable;

import java.util.List;

public class DataContainer {
    /**
     * Container to pack data from several repos and send to frontend
     */

    private List<? extends Analytics> data;
    private List<? extends AbstractDictTable> dict;

    public DataContainer(List<? extends Analytics> analyticsData, List<? extends AbstractDictTable> dictData){
        this.data = analyticsData;
        this.dict = dictData;
    }

    public List<? extends Analytics> getData() {
        return data;
    }

    public void setData(List<? extends Analytics> data) {
        this.data = data;
    }

    public List<? extends AbstractDictTable> getDict() {
        return dict;
    }

    public void setDict(List<? extends AbstractDictTable> dict) {
        this.dict = dict;
    }



}
