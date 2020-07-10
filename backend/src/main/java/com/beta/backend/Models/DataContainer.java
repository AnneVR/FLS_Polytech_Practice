package com.beta.backend.Models;

import com.beta.backend.Models.Analytics.Analytics;
import com.beta.backend.Models.Dicts.AbstractDictTable;

import java.util.List;

public class DataContainer {
    /**
     * Container to pack data from several repos and send to frontend
     */

    private List<Analytics> data;
    private List<AbstractDictTable> dict;

    public List<Analytics> getData() {
        return data;
    }

    public void setData(List<Analytics> data) {
        this.data = data;
    }

    public List<AbstractDictTable> getDict() {
        return dict;
    }

    public void setDict(List<AbstractDictTable> dict) {
        this.dict = dict;
    }



}
