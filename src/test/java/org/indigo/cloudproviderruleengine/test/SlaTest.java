package org.indigo.cloudproviderruleengine.test;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.indigo.cloudproviderruleengine.Sla;
import org.indigo.cloudproviderruleengine.Service;
import org.indigo.cloudproviderruleengine.Target;
import org.indigo.cloudproviderruleengine.Restrictions;
import org.indigo.cloudproviderruleengine.SlaNormalizations;

public class SlaTest {
  @Test
  public void test( ) {
    Restrictions r = new Restrictions( );
    r.total_limit = 10;
    r.total_guaranteed = 1;
    r.instance_limit = 100;
    r.instance_guaranteed = 1;
    r.user_limit = 5;
    r.user_guaranteed = 1;

    if(r!=null)
      assertTrue(r.total_limit==10);
    
    ArrayList<String> targetTypes = new ArrayList<String>();
    targetTypes.add( "public_ip" );
    targetTypes.add( "computing_time" );
    targetTypes.add( "num_cpus" );
    targetTypes.add( "mem_size" );
    targetTypes.add( "disk_size" );
    targetTypes.add( "upload_bandwidth" );
    targetTypes.add( "download_bandwidth" );
    targetTypes.add( "upload_aggregated" );
    targetTypes.add( "download_aggregated" );    

    for(String type : targetTypes) {

	ArrayList<Target> t = new ArrayList<Target>();
	Target T = new Target();
	T.type = type;
	T.unit = "unit";
	T.restrictions = r;
	t.add(T);
    
	if(T!=null)
	    assertTrue(T.type.compareTo("")!=0);   
       
	//Service S = new Service();
	ArrayList<Service> s = new ArrayList<Service>( );
	
	Service S = new Service("id", "type", t);
	if(S!=null)
	    assertTrue(S.type.compareTo("type")==0);
	
	s.add(S);
	SlaNormalizations.priority_file = "sla_priorities.json";
	//sla.reloadPriorityFile( );
	Sla sla = new Sla("id", "customer", "provider", "start_date", "end_date", s );
	sla.reloadPriorityFile( );
	assertTrue( sla.toString().compareTo("") != 0);
    }
  }
}
