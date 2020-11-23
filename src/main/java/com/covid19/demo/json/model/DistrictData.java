
package com.covid19.demo.json.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictData {
  
  @JsonProperty("id")
  public String id;
  @JsonProperty("state")
  public Object state;
  @JsonProperty("name")
  public String name;
  @JsonProperty("confirmed")
  public Integer confirmed;
  @JsonProperty("recovered")
  public Object recovered;
  @JsonProperty("deaths")
  public Object deaths;
  @JsonProperty("oldConfirmed")
  public Integer oldConfirmed;
  @JsonProperty("oldRecovered")
  public Object oldRecovered;
  @JsonProperty("oldDeaths")
  public Object oldDeaths;
  @JsonProperty("zone")
  public String zone;
  
}
