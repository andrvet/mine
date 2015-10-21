package NCBIXPathSAX;
/*

http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=pubmed&id=25239749,123

<eSummaryResult>

	<DocSum>
		<Id>25239749</Id>
		...
		<Item Name="DOI" Type="String">10.1007/978-1-4939-1652-8_11</Item>
		...
	</DocSum>
	
	<DocSum>
		<Id>123</Id>
		...
	</DocSum>
	
</eSummaryResult>
 */
public class NCBIDocSum {
	private String id;
	private String doi;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}

	@Override
	public String toString() {
		return "pubmedid=" + this.id + " DOI=" + this.doi;
	}
	
}
