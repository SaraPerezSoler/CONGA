package es.main.parser.pandorabots.agent;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "callapi")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Callapi {
	public String response_code_var;
	public String url;
	public String method;
	public CallapiHeader header;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "query")
	public List<CallapiQuery> queryParams;

	public Callapi() {
	}

	public Callapi(String response_code_var, String url, String method, CallapiHeader header,
			List<CallapiQuery> queryParams) {
		this.response_code_var = response_code_var;
		this.url = url;
		this.method = method;
		this.header = header;
		this.queryParams = queryParams;
	}

	public String getResponse_code_var() {
		return response_code_var;
	}

	public void setResponse_code_var(String response_code_var) {
		this.response_code_var = response_code_var;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public CallapiHeader getHeader() {
		return header;
	}

	public void setHeader(CallapiHeader header) {
		this.header = header;
	}

	public List<CallapiQuery> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(List<CallapiQuery> queryParams) {
		this.queryParams = queryParams;
	}

	@Override
	public String toString() {
		return "Callapi [response_code_var=" + response_code_var + ", url=" + url + ", method=" + method + ", header="
				+ header + ", queryParams=" + queryParams + "]";
	}
}
