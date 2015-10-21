
package kr.kyu.vo;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ForecastWarningUltrafineParticleOfDustService {

    @JsonProperty("list_total_count")
    private Integer listTotalCount;
    @JsonProperty("RESULT")
    private Result result;
    @JsonProperty("row")
    private List<Row> row = new ArrayList<Row>();

	/**
	 * @return the listTotalCount
	 */
	public Integer getListTotalCount() {
		return listTotalCount;
	}
	/**
	 * @param listTotalCount the listTotalCount to set
	 */
	public void setListTotalCount(Integer listTotalCount) {
		this.listTotalCount = listTotalCount;
	}
	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}
	/**
	 * @return the row
	 */
	public List<Row> getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(List<Row> row) {
		this.row = row;
	}
}
