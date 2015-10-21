package NCBIXPathSAX;

import java.util.ArrayList;

public class NCBIResponse {

	/*
	 "status":"ok",
	"responseDate":"2015-06-22 13:26:10",
	"request":"tool=a;email=al%40a.com;format=json;ids=23193287%2C2836360%2C11003848%2C11003843%2C10987149",
	"records":[

{

    "pmcid":"PMC211167",
    "pmid":"2836360",
    "versions":[
        {
            "pmcid":"PMC211167.1",
            "current":"true"
        }
    ]

},
{

    "pmcid":"PMC3531190",
    "pmid":"23193287",
    "doi":"10.1093/nar/gks1195",
    "versions":[
        {
            "pmcid":"PMC3531190.1",
            "current":"true"
        }
    ]

},
{

    "pmid":"10987149",
    "live":"false",
    "status":"error",
    "errmsg":"invalid article id"

},
	 */
	
	private String status;
	private String responseDate;
	private String request;
	private ArrayList<NCBIRecord> records;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseDate() {
		return responseDate;
	}
	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public ArrayList<NCBIRecord> getRecords() {
		return records;
	}
	public void setRecords(ArrayList<NCBIRecord> records) {
		this.records = records;
	}

}
