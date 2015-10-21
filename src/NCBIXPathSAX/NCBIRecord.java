package NCBIXPathSAX;

import java.util.ArrayList;

/*
 * represents a record in NCBI WS response. The response contains an array of such records
 */
public class NCBIRecord {

		private String pmcid;
		private String pmid;
		private String doi;
		private ArrayList<String> versions;
		
		private String live;
		private String status;
		private String errmsg;
		
		public String getPmcid() {
			return pmcid;
		}
		public void setPmcid(String pmcid) {
			this.pmcid = pmcid;
		}
		public String getPmid() {
			return pmid;
		}
		public void setPmid(String pmid) {
			this.pmid = pmid;
		}
		public String getDoi() {
			return doi;
		}
		public void setDoi(String doi) {
			this.doi = doi;
		}

		public ArrayList<String> getVersions() {
			return versions;
		}
		public void setVersions(ArrayList<String> versions) {
			this.versions = versions;
		}
		public String getLive() {
			return live;
		}
		public void setLive(String live) {
			this.live = live;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getErrmsg() {
			return errmsg;
		}
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
	}