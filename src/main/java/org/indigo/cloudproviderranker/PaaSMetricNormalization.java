package org.indigo.cloudproviderranker;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import java.util.logging.Logger;
import java.util.logging.Level;

public class PaaSMetricNormalization {

  public static String normalization_file = null;

  public int   OCCI_Create_VM_availability 	= 1;
  public float OCCI_CreateVM_Response_Time 	= (float)0.001;
  public int   OCCI_CreateVM_Result 		= 1;
  public int   OCCI_Delete_VM_Availability 	= 1;
  public float OCCI_DeleteVM_Response_Time 	= (float)0.001;
  public int   OCCI_DeleteVM_Result 		= 1;
  public int   General_OCCI_API_Availability	= 1;
  public float General_OCCI_API_Response_Time 	= (float)0.001;
  public int   General_OCCI_API_Result 		= 1;
  public int   OCCI_Inspect_VM_availability 	= 1;
  public float OCCI_InspectVM_Response_Time 	= (float)0.001;
  public int   OCCI_InspectVM_Result 		= 1;

  //----------------------------------------------------------------------------------------
  public PaaSMetricNormalization( ) {
    this.update(1,0.001f,1,1,0.001f,1,1,0.001f,1,1,0.001f,1);
  }

  //----------------------------------------------------------------------------------------
  public PaaSMetricNormalization( int   OCCI_Create_VM_availability,
				  float OCCI_CreateVM_Response_Time,
				  int   OCCI_CreateVM_Result,
				  int   OCCI_Delete_VM_Availability,
				  float OCCI_DeleteVM_Response_Time,
				  int   OCCI_DeleteVM_Result,
				  int   General_OCCI_API_Availability,
				  float General_OCCI_API_Response_Time,
				  int   General_OCCI_API_Result,
				  int   OCCI_Inspect_VM_availability,
				  float OCCI_InspectVM_Response_Time,
				  int   OCCI_InspectVM_Result )
  { 
    this.OCCI_Create_VM_availability    = OCCI_Create_VM_availability;
    this.OCCI_CreateVM_Response_Time    = OCCI_CreateVM_Response_Time;
    this.OCCI_CreateVM_Result 		= OCCI_CreateVM_Result;
    this.OCCI_Delete_VM_Availability    = OCCI_Delete_VM_Availability;
    this.OCCI_DeleteVM_Response_Time    = OCCI_DeleteVM_Response_Time;
    this.OCCI_DeleteVM_Result 		= OCCI_DeleteVM_Result;
    this.General_OCCI_API_Availability  = General_OCCI_API_Availability;
    this.General_OCCI_API_Response_Time = General_OCCI_API_Response_Time;
    this.General_OCCI_API_Result 	= General_OCCI_API_Result;
    this.OCCI_Inspect_VM_availability   = OCCI_Inspect_VM_availability;
    this.OCCI_InspectVM_Response_Time   = OCCI_InspectVM_Response_Time;
    this.OCCI_InspectVM_Result 		= OCCI_InspectVM_Result;
  }
  
  //----------------------------------------------------------------------------------------
  @Override
  public String toString( ) {
    return ToStringBuilder.reflectionToString(this);
  }

  //----------------------------------------------------------------------------------------
  public void updateFromFile( ) {
    String Line = "";
    if(normalization_file != null) {
      InputStream is = null;
      try {
        is = new FileInputStream(new File(normalization_file));
        InputStreamReader inputReader = new InputStreamReader(is);
        BufferedReader buffReader     = new BufferedReader(inputReader);
        String line = "";
        while( (line = buffReader.readLine()) != null) {
          Line += line;
        }
      } catch(Exception e) {
        this.update(1,0.001f,1,1,0.001f,1,1,0.001f,1,1,0.001f,1);
      } catch(Throwable t) {
        this.update(1,0.001f,1,1,0.001f,1,1,0.001f,1,1,0.001f,1);
      }
      Gson gson = new Gson();
      JsonElement E = gson.fromJson(Line, JsonElement.class);	  
      PaaSMetricNormalization paaSMetricNormalization = (PaaSMetricNormalization)gson.fromJson(E.getAsJsonObject( ), PaaSMetricNormalization.class);
      updateFromObject( paaSMetricNormalization );

    } else {
      this.update(1,0.001f,1,1,0.001f,1,1,0.001f,1,1,0.001f,1);
    }
  }

  //----------------------------------------------------------------------------------------
  public void update(int   OCCI_Create_VM_availability,
				  float OCCI_CreateVM_Response_Time,
				  int   OCCI_CreateVM_Result,
				  int   OCCI_Delete_VM_Availability,
				  float OCCI_DeleteVM_Response_Time,
				  int   OCCI_DeleteVM_Result,
				  int   General_OCCI_API_Availability,
				  float General_OCCI_API_Response_Time,
				  int   General_OCCI_API_Result,
				  int   OCCI_Inspect_VM_availability,
				  float OCCI_InspectVM_Response_Time,
				  int   OCCI_InspectVM_Result )
  { 
    this.OCCI_Create_VM_availability    = OCCI_Create_VM_availability;
    this.OCCI_CreateVM_Response_Time    = OCCI_CreateVM_Response_Time;
    this.OCCI_CreateVM_Result 		= OCCI_CreateVM_Result;
    this.OCCI_Delete_VM_Availability    = OCCI_Delete_VM_Availability;
    this.OCCI_DeleteVM_Response_Time    = OCCI_DeleteVM_Response_Time;
    this.OCCI_DeleteVM_Result 		= OCCI_DeleteVM_Result;
    this.General_OCCI_API_Availability  = General_OCCI_API_Availability;
    this.General_OCCI_API_Response_Time = General_OCCI_API_Response_Time;
    this.General_OCCI_API_Result 	= General_OCCI_API_Result;
    this.OCCI_Inspect_VM_availability   = OCCI_Inspect_VM_availability;
    this.OCCI_InspectVM_Response_Time   = OCCI_InspectVM_Response_Time;
    this.OCCI_InspectVM_Result 		= OCCI_InspectVM_Result;
  }

  //----------------------------------------------------------------------------------------
  private void updateFromObject( PaaSMetricNormalization obj ) {
    this.OCCI_Create_VM_availability    = obj.OCCI_Create_VM_availability;
    this.OCCI_CreateVM_Response_Time    = obj.OCCI_CreateVM_Response_Time;
    this.OCCI_CreateVM_Result 		= obj.OCCI_CreateVM_Result;
    this.OCCI_Delete_VM_Availability    = obj.OCCI_Delete_VM_Availability;
    this.OCCI_DeleteVM_Response_Time    = obj.OCCI_DeleteVM_Response_Time;
    this.OCCI_DeleteVM_Result 		= obj.OCCI_DeleteVM_Result;
    this.General_OCCI_API_Availability  = obj.General_OCCI_API_Availability;
    this.General_OCCI_API_Response_Time = obj.General_OCCI_API_Response_Time;
    this.General_OCCI_API_Result 	= obj.General_OCCI_API_Result;
    this.OCCI_Inspect_VM_availability   = obj.OCCI_Inspect_VM_availability;
    this.OCCI_InspectVM_Response_Time   = obj.OCCI_InspectVM_Response_Time;
    this.OCCI_InspectVM_Result 		= obj.OCCI_InspectVM_Result;
  }

  public void toCustomFile( String ClientIP ) {
    String customNormalizationFile = "/usr/share/java/cpr/";
    if(normalization_file!=null) {
      customNormalizationFile = (new File(normalization_file)).getParent();
    }
    customNormalizationFile = customNormalizationFile + "/paasmetric_normalization-" + ClientIP + ".json";
    Gson gson = new Gson();
    String params = gson.toJson( this );
    Logger.getLogger("").log(Level.INFO, "Serialized PaaSMetricNormalization: [" + params + "]");
  }
}
