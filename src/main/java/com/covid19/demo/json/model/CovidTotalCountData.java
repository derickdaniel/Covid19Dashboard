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
public class CovidTotalCountData {
  
  @JsonProperty("state")
  public String state;
  @JsonProperty("active")
  public Integer active;
  @JsonProperty("confirmed")
  public Integer confirmed;
  @JsonProperty("recovered")
  public Integer recovered;
  @JsonProperty("deaths")
  public Integer deaths;
  @JsonProperty("aChanges")
  public Integer aChanges;
  @JsonProperty("cChanges")
  public Integer cChanges;
  @JsonProperty("rChanges")
  public Integer rChanges;
  @JsonProperty("dChanges")
  public Integer dChanges;
  
}