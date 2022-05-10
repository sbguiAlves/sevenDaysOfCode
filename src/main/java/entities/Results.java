package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Results {
    @SerializedName("expression")
    @Expose
    String search;

    @SerializedName("results")
    @Expose
    private final List<Result> resultList = new ArrayList<>();

    public List<Result> getResultList()
    {
        return resultList;
    }

    public String getFirstResultID()
    {
        return resultList.get(0).getCompanyID();
    }

    public String getFirstResultName()
    {
        return resultList.get(0).getCompanyTitle();
    }

    @Override
    public String toString() {
        return String.format("Company Name: %s, Results: %s", search, resultList);
    }

}

class Result{
    @SerializedName("id")
    @Expose
    String companyId;

    @SerializedName("title")
    @Expose
    String companyTitle;

    public String getCompanyID() {
        return companyId;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Company Name: %s\n", companyId, companyTitle);
    }
}
