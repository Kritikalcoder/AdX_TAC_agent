package adx.variants.thirtydaysgame;

import java.util.HashSet;
import java.util.Vector;

import java.util.Set;

import adx.exceptions.AdXException;
import adx.structures.Campaign;
import adx.structures.MarketSegment;
import adx.structures.SimpleBidEntry;
import adx.util.Logging;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeAgent extends ThirtyDaysThirtyCampaignsAgent 
{	
	int x,y,z;
	
	public ThreeAgent(String host, int port) 
  	{	
		super(host, port);
		x = 3; y = 6; z = 9;
		
  	}
	
	public int isSubset(String s, String ss) 
	{	
		if (s.equals(ss))
			return 1;
		String[] sps = s.split("_");
		String[] spss = ss.split("_");
		int fl = 1, fl2 = 0;
		for (int i = 0; i<sps.length; i++)
		{	
			fl2 = 0;
			for (int j = 0; j< spss.length; j++)
			{	
				if (sps[i].equals(spss[j]))
			  	{
					fl2 = 1;
					break;
			  	}
			}
			fl = fl*fl2;
		}
		return fl;
	}

	public int computef1(String s)
	{	
		if(s.length()>18)
			return x;
		else if(s.length()>=8 && s!="LOW_INCOME" && s!="HIGH_INCOME")
			return y;
		return z; 
	}
  
	@Override
	protected ThirtyDaysBidBundle getBidBundle(int day) 
	{
		try 
		{	
			Map<String, Double> map = new HashMap<String, Double>();
			map.put("MALE_YOUNG_LOW_INCOME",1836.0);
			map.put("MALE_YOUNG_HIGH_INCOME",517.0);
			map.put("MALE_OLD_LOW_INCOME",1795.0);
			map.put("MALE_OLD_HIGH_INCOME",808.0);
			map.put("FEMALE_YOUNG_LOW_INCOME",1980.0);
			map.put("FEMALE_YOUNG_HIGH_INCOME",256.0);
			map.put("FEMALE_OLD_LOW_INCOME",2401.0);
			map.put("FEMALE_OLD_HIGH_INCOME",407.0);
			
			map.put("YOUNG_LOW_INCOME",3816.0);
			map.put("YOUNG_HIGH_INCOME",773.0);
			map.put("OLD_LOW_INCOME",4196.0);
			map.put("OLD_HIGH_INCOME",1215.0);
			map.put("FEMALE_YOUNG",2236.0);
			map.put("FEMALE_OLD",2808.0);
			map.put("FEMALE_LOW_INCOME",4381.0);
			map.put("FEMALE_HIGH_INCOME",663.0);
			map.put("MALE_YOUNG",2353.0);
			map.put("MALE_OLD",2603.0);
			map.put("MALE_LOW_INCOME",3631.0);
			map.put("MALE_HIGH_INCOME",1325.0);
			
			
			map.put("MALE",4956.0);
			map.put("YOUNG",4589.0);
			map.put("OLD",5411.0);
			map.put("HIGH_INCOME",1988.0);
			map.put("LOW_INCOME",8012.0);
			map.put("FEMALE",5044.0);
			
			
			Map<String, adx.structures.MarketSegment > imp = new HashMap<String, adx.structures.MarketSegment >();
			
			imp.put("MALE_YOUNG_LOW_INCOME",MarketSegment.MALE_YOUNG_LOW_INCOME);
			imp.put("MALE_YOUNG_HIGH_INCOME",MarketSegment.MALE_YOUNG_HIGH_INCOME);
			imp.put("MALE_OLD_LOW_INCOME",MarketSegment.MALE_OLD_LOW_INCOME);
			imp.put("MALE_OLD_HIGH_INCOME", MarketSegment.MALE_OLD_HIGH_INCOME);
			imp.put("FEMALE_YOUNG_LOW_INCOME",MarketSegment.FEMALE_YOUNG_LOW_INCOME);
			imp.put("FEMALE_YOUNG_HIGH_INCOME",MarketSegment.FEMALE_YOUNG_HIGH_INCOME);
			imp.put("FEMALE_OLD_LOW_INCOME",MarketSegment.FEMALE_OLD_LOW_INCOME);
			imp.put("FEMALE_OLD_HIGH_INCOME", MarketSegment.FEMALE_OLD_HIGH_INCOME);
      
			Map<adx.structures.MarketSegment, String> mp = new HashMap<adx.structures.MarketSegment, String>();
		      mp.put(MarketSegment.YOUNG_LOW_INCOME,"YOUNG_LOW_INCOME");
		      mp.put(MarketSegment.YOUNG_HIGH_INCOME,"YOUNG_HIGH_INCOME");
		      mp.put(MarketSegment.OLD_LOW_INCOME,"OLD_LOW_INCOME");
		      mp.put(MarketSegment.OLD_HIGH_INCOME,"OLD_HIGH_INCOME");
		      mp.put(MarketSegment.MALE_LOW_INCOME,"MALE_LOW_INCOME");
		      mp.put(MarketSegment.MALE_HIGH_INCOME,"MALE_HIGH_INCOME");
		      mp.put(MarketSegment.FEMALE_LOW_INCOME,"FEMALE_LOW_INCOME");
		      mp.put(MarketSegment.FEMALE_HIGH_INCOME,"FEMALE_HIGH_INCOME");
		      mp.put(MarketSegment.MALE_YOUNG,"MALE_YOUNG");
		      mp.put(MarketSegment.MALE_OLD,"MALE_OLD");
		      mp.put(MarketSegment.FEMALE_YOUNG,"FEMALE_YOUNG");
		      mp.put(MarketSegment.FEMALE_OLD,"FEMALE_OLD");

		      mp.put(MarketSegment.MALE_YOUNG_LOW_INCOME,"MALE_YOUNG_LOW_INCOME");
		      mp.put(MarketSegment.MALE_YOUNG_HIGH_INCOME,"MALE_YOUNG_HIGH_INCOME");
		      mp.put(MarketSegment.MALE_OLD_LOW_INCOME,"MALE_OLD_LOW_INCOME");
		      mp.put(MarketSegment.MALE_OLD_HIGH_INCOME,"MALE_OLD_HIGH_INCOME");
		      mp.put(MarketSegment.FEMALE_YOUNG_LOW_INCOME,"FEMALE_YOUNG_LOW_INCOME");
		      mp.put(MarketSegment.FEMALE_YOUNG_HIGH_INCOME,"FEMALE_YOUNG_HIGH_INCOME");
		      mp.put(MarketSegment.FEMALE_OLD_LOW_INCOME,"FEMALE_OLD_LOW_INCOME");
		      mp.put(MarketSegment.FEMALE_OLD_HIGH_INCOME,"FEMALE_OLD_HIGH_INCOME");
			  
		      mp.put(MarketSegment.LOW_INCOME,"LOW_INCOME");
		      mp.put(MarketSegment.HIGH_INCOME,"HIGH_INCOME");
		      mp.put(MarketSegment.YOUNG,"YOUNG");
		      mp.put(MarketSegment.OLD,"OLD");
		      mp.put(MarketSegment.MALE,"MALE");
		      mp.put(MarketSegment.FEMALE,"FEMALE");
			
			
			Campaign c = null;
			if (day <= 30) 
			{	Logging.log("[-] Bid for campaign " + day + " which is: " + this.setCampaigns[day - 1]);
				c = this.setCampaigns[day - 1];
			} 
			else 
			{	throw new AdXException("[x] Bidding for invalid day " + day + ", bids in this game are only for day 1 to 30.");
			}
			
			Set<SimpleBidEntry> bidEntries = new HashSet<SimpleBidEntry>();
			String[] array = new String[8];
			
			//System.out.println("***************************************");
			//for ( MarketSegment m : MarketSegment . values())
			//	System.out.println(map.get(mp.get(m)));

			//System.out.println("***************************************");
			
			int f1 = computef1(mp.get(c.getMarketSegment()));
			f1 = 26/f1 ;
			Logging.log(f1);
			array[0]="MALE_YOUNG_LOW_INCOME"; 
			array[1]="MALE_YOUNG_HIGH_INCOME"; 
			array[2]="MALE_OLD_LOW_INCOME"; 
			array[3]="MALE_OLD_HIGH_INCOME"; 
			array[4]="FEMALE_YOUNG_LOW_INCOME"; 
			array[5]="FEMALE_YOUNG_HIGH_INCOME"; 
			array[6]="FEMALE_OLD_LOW_INCOME"; 
			array[7]="FEMALE_OLD_HIGH_INCOME";

			int sum = 0 ;
			for(int i=0;i<8;i++)
			{
				if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
					sum += map.get(array[i]);
			}
			
			Logging.log(sum);
			
			double B = sum*0.75;
			double A = sum*0.25;		

			if(c.getReach() > B)
			{	
				// low risk;	
				for(int i=0;i<8;i++)
				{	
					if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
					{	double f2 = map.get(array[i])/sum ;
						if(c.getBudget()>0.1)
						{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f1*f2/(double)c.getReach()), c.getBudget()));
						}
						else
						{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
						}
					}
				}
			}
			else if(c.getReach() > A)
			{	
				double f2_med;
				// Medium Risk	
				if(computef1(mp.get(c.getMarketSegment())) == x)
				{	
					f2_med = map.get(mp.get(c.getMarketSegment()))/sum ;
					// Most Specific
					if(c.getBudget()>0.1)
					{	bidEntries.add(new SimpleBidEntry(c.getMarketSegment(), (c.getBudget()*f1*f2_med/(double)c.getReach()), c.getBudget()));
					}
					else
					{	bidEntries.add(new SimpleBidEntry(c.getMarketSegment(), 1, c.getReach()*0.4));
					}
				}
				else if(computef1(mp.get(c.getMarketSegment())) == y)
				{	// Belongs to 2 class
					
					double[] f2 = new double[30];
					int k=0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							f2[k] = map.get(mp.get(c.getMarketSegment()));
							k++;
						}
					}
					
					f2[0] = f2[0]/(f2[0]+ f2[1]);
					f2[1] = f2[1]/(f2[0]+ f2[1]);
					
					if(f2[0] < f2[1]) {
						f2[0] = (f2[0]* 2)/3;
						f2[1] = f2[1] + (f2[0]/3);
					}
					else
					{	f2[1] = (f2[1]* 2)/3;
						f2[0] = f2[0] + (f2[1]/3);
					}
					
					k = 0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							if(c.getBudget()>0.1)
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f1*f2[k]/(double)c.getReach()), c.getBudget()));
							}
							else
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
							}
							k++;
						}
					}
					
				}
				else
				{	// Belongs to Single Class
					

					double[] f2 = new double[30];
					int k=0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							//System.out.println(mp.get(c.getMarketSegment()));
							f2[k] = map.get(mp.get(c.getMarketSegment()));
							//System.out.println(f2[k]);
							
							k++;
						}
					}
					
					double min = f2[0] ;
					int ind = 0;
					double sum_k = 0;
					
					for(int i=1;i<4;i++)
					{	//f2[i] = f2[i]/(f2[0]+ f2[1] + f2[2]+ f2[3]);
						sum_k += f2[i];
						if( f2[i] < min )
						{	min = f2[i];
							ind = i;
						}
					}
					sum_k -= min;
					f2[ind] = 0;
					
					for(int i=1;i<4;i++)
					{	
						f2[i]/=sum_k;
					}
					
					k = 0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							if(c.getBudget()>0.1)
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f1*f2[k]/(double)c.getReach()), c.getBudget()));
							}
							else
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
							}
							k++;
						}
					}
					
				}
			}
			else 
			{	// High Risk
				
				double f2_high;	
				if(computef1(mp.get(c.getMarketSegment())) == x)
				{	
					f2_high = map.get(mp.get(c.getMarketSegment()))/sum ;
					// Most Specific
					if(c.getBudget()>0.1)
					{	bidEntries.add(new SimpleBidEntry(c.getMarketSegment(), (c.getBudget()*f1*f2_high/(double)c.getReach()), c.getBudget()));
					}
					else
					{	bidEntries.add(new SimpleBidEntry(c.getMarketSegment(), 1, c.getReach()*0.4));
					}
				}
				else if(computef1(mp.get(c.getMarketSegment())) == y)
				{	// Belongs to 2 class
					
					double[] f2 = new double[2];
					int k=0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							f2[k] = map.get(mp.get(c.getMarketSegment()));
							k++;
						}
					}
					
					f2[0] = f2[0]/(f2[0]+ f2[1]);
					f2[1] = f2[1]/(f2[0]+ f2[1]);
					
					if(f2[0] < f2[1]) {
						f2[0] = (f2[0]/2);
						f2[1] = f2[1] + (f2[0]/2);
					}
					else
					{	f2[1] = (f2[1]/2);
						f2[0] = f2[0] + (f2[1]/2);
					}
					
					k = 0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							if(c.getBudget()>0.1)
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f1*f2[k]/(double)c.getReach()), c.getBudget()));
							}
							else
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
							}
							k++;
						}
					}
					
				}
				else
				{	// Belongs to Single Class
					

					double[] f2 = new double[4];
					int k=0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							f2[k] = map.get(mp.get(c.getMarketSegment()));
							k++;
						}
					}
					
					double min = f2[0] ;
					int ind = 0;
					double sum_k = 0;
					
					for(int i=1;i<4;i++)
					{	//f2[i] = f2[i]/(f2[0]+ f2[1] + f2[2]+ f2[3]);
						sum_k += f2[i];
						if( f2[i] < min )
						{	min = f2[i];
							ind = i;
						}
					}
					sum_k -= min;
					f2[ind] = 0;
					
					for(int i=1;i<4;i++)
					{	
						f2[i]/=sum_k;
					}
					
					// Second min
					min = 10000;
					ind = -1;
					sum_k = 0;
					
					for(int i=1;i<4;i++)
					{	//f2[i] = f2[i]/(f2[0]+ f2[1] + f2[2]+ f2[3]);
						sum_k += f2[i];
						if( f2[i] < min && f2[i]!=0)
						{	min = f2[i];
							ind = i;
						}
					}
					sum_k -= min;
					f2[ind] = 0;
					
					for(int i=1;i<4;i++)
					{	
						f2[i]/=sum_k;
					}
					
					k = 0;
					
					for(int i=0;i<8;i++)
					{	
						if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
						{	
							if(c.getBudget()>0.1)
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f1*f2[k]/(double)c.getReach()), c.getBudget()));
							}
							else
							{	bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
							}
							k++;
						}
					}
					
				}
				
			}

			Logging.log("[-] bidEntries = " + bidEntries);
			return new ThirtyDaysBidBundle(day, c.getId(), c.getBudget(), bidEntries);
		} 
		catch (AdXException e) 
		{	Logging.log("[x] Something went wrong getting the bid bundle: " + e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) 
	{	
		ThreeAgent agent = new ThreeAgent("localhost", 9898);
		agent.connect("ThreeAgent");
	}
}
