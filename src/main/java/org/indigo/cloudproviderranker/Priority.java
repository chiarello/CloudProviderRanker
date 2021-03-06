package org.indigo.cloudproviderranker;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Doc TODO.
 */
public class Priority implements Comparable<Priority> {
  /**
   * Doc TODO.
   */
  @SerializedName("sla_id") public String slaId;
  /**
   * Doc TODO.
   */
  @SerializedName("service_id") public String serviceId;
  /**
   * Doc TODO.
   */
  public float  weight;

  /**
   * Doc TODO.
   */
  @Override
  public final String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  /**
   * Doc TODO.
   */
  public final int compareTo(final Priority prio) {
    if (weight == prio.weight) {
      return 0;
    }
    int ret = weight > prio.weight ? -1 : 1;
    return ret;
  }
}
