import java.util.*;
import java.text.DecimalFormat;

public class bettingAid {

	private static float homeOdds, drawOdds, awayOdds, homeWin, drawWin, awayWin, inplayHomeWin, inplayDrawWin, inplayAwayWin = 0.0f;
	private static String homeTeam, awayTeam, homeDraw, homeAway, drawHome, drawAway, awayDraw, awayHome;
	private static float stake = 25.0f;
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	public static float winnings(float odds) {
		return (odds * stake - stake);
	}
	
	public static float profitEach(float wins1 ,float wins2) {
		return ((wins1 + wins2)/2);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter Home Team Name - ");
		homeTeam = scan.nextLine();
		System.out.print("Enter Home Team Odds(Decimal) - ");
		if (scan.hasNextFloat()) {
			homeOdds = scan.nextFloat();
		}
		else {
			scan.next();
			System.out.print("Enter Home Team Odds(Decimal) - ");
			homeOdds = scan.nextFloat();
			}
		
		System.out.print("Enter Away Team Name - ");
		scan.nextLine(); 							// Refreshes scanner
		awayTeam = scan.nextLine();
		System.out.print("Enter Away Team Odds(Decimal) - ");
		if (scan.hasNextFloat()) {
		awayOdds = scan.nextFloat();		
		}
		else {
			scan.next();
			System.out.print("Enter Away Team Odds(Decimal) - ");
			awayOdds = scan.nextFloat();
		}
		scan.nextLine();
		System.out.print("Enter Draw Odds(Decimal) - ");
		if (scan.hasNextDouble()) {
			drawOdds = scan.nextFloat();
		}
		else {
			System.out.print("Enter Draw Odds(Decimal) - ");
			scan.next();
			drawOdds = scan.nextFloat();
		}
		scan.close();
		
		homeWin = winnings(homeOdds);
		drawWin = winnings(drawOdds);
		awayWin = winnings (awayOdds);
		inplayHomeWin = homeWin - stake;
		inplayDrawWin = drawWin - stake;
		inplayAwayWin = awayWin - stake;
		
		homeDraw = ("(" + homeTeam + " &  DRAW)");
		homeAway = ("(" + homeTeam + " & " + awayTeam + ")");
		drawHome = ("(DRAW  & " + homeTeam + ")");
		drawAway = ("(DRAW  & " + awayTeam + ")");
		awayDraw = ("(" + awayTeam + " &  DRAW)");
		awayHome = ("(" + awayTeam + " & " + homeTeam + ")");
		
		System.out.println("\nFREE INPLAY BET ON BET365. Pre game and in-play stakes are £" + stake + " each. ");
		System.out.println("BETTING OPTIONS - PROFIT IN POUNDS AFTER INPLAY STAKE IS REFUNDED");
		System.out.println("PRE-GAME    IN-PLAY         " + homeTeam + " WINS     DRAW WINS    "+ awayTeam + " WINS\n"); 
		
		System.out.println(homeTeam + "    DRAW              £" + df.format(homeWin) + "         £" + df.format(inplayDrawWin) + "         -£"+ stake + "        (£" + df.format(stake/(awayOdds-1)) + ") on " + awayTeam + " to win back losses if using this method.");
		System.out.println(homeTeam + "    " + awayTeam + "            £" + df.format(homeWin) + "        -£" + stake + "          £" + df.format(inplayAwayWin));	
		System.out.println(awayTeam + "    DRAW              -£" + stake + "          £" + df.format(inplayDrawWin) + "         £" + df.format(awayWin)+ "        (£" + df.format(stake/(homeOdds-1)) + ") on " + homeTeam + " to win back losses if using this method.");
		System.out.println(awayTeam + "    " + homeTeam + "            £" + df.format(inplayHomeWin) + "         -£" + stake + "          £" + df.format(awayWin));
		System.out.println("DRAW     " + homeTeam + "            £ " + df.format(inplayHomeWin) + "        £" + df.format(drawWin) + "         -£" + stake );
		System.out.println("DRAW     " + awayTeam + "            -£" + stake + "         £" + df.format(drawWin) + "          £" + df.format(inplayAwayWin) + "\n");
	
		System.out.println("PAIRINGS TO BET ON (PROFIT PER PERSON)    "+ homeTeam + " WIN     DRAW WIN    " + awayTeam + " WIN");
		System.out.println(homeDraw + " AND " + homeAway + "       £" + df.format(homeWin) + "        £" + df.format(profitEach(inplayDrawWin,-stake)) + "       £" + df.format(profitEach(-stake,inplayAwayWin)));
		System.out.println(homeDraw + " AND " + awayDraw + "       £" + df.format(profitEach(homeWin,-stake)) + "        £" + df.format(inplayDrawWin) + "       £" + df.format(profitEach(-stake,awayWin)));
		System.out.println(homeDraw + " AND " + awayHome + "       £" + df.format(profitEach(homeWin,inplayHomeWin)) + "        £" + df.format(profitEach(inplayDrawWin,-stake)) + "       £" + df.format(profitEach(-stake,awayWin)));
		System.out.println(homeDraw + " AND " + drawHome + "       £" + df.format(profitEach(homeWin,inplayHomeWin)) + "        £" + df.format(profitEach(inplayDrawWin,drawWin)) + "       £" + -stake);
		System.out.println(homeDraw + " AND " + drawAway + "       £" + df.format(profitEach(homeWin,-stake)) + "        £" + df.format(profitEach(inplayDrawWin,drawWin)) + "       £" + df.format(profitEach(-stake,inplayAwayWin)));
		System.out.println(homeAway + " AND " + awayDraw + "       £" + df.format(profitEach(homeWin,-stake)) + "        £" + df.format(profitEach(-stake,inplayDrawWin)) + "       £" + df.format(profitEach(inplayAwayWin,awayWin)));
		System.out.println(homeAway + " AND " + awayHome + "       £" + df.format(profitEach(homeWin,inplayHomeWin)) + "        £" + -stake + "       £" + df.format(profitEach(inplayAwayWin,awayWin)));
		System.out.println(homeAway + " AND " + drawHome + "       £" + df.format(profitEach(homeWin,inplayHomeWin)) + "        £" + df.format(profitEach(-stake,drawWin)) + "       £" + df.format(profitEach(inplayAwayWin,-stake))); 
		System.out.println(homeAway + " AND " + drawAway + "       £" + df.format(profitEach(homeWin,-stake)) + "        £" + df.format(profitEach(-stake,drawWin)) + "       £" + df.format(inplayAwayWin));	
		System.out.println(awayDraw + " AND " + awayHome + "       £" + df.format(profitEach(-stake,inplayHomeWin)) + "        £" + df.format(profitEach(inplayDrawWin,-stake)) + "       £" + df.format(awayWin));
		System.out.println(awayDraw + " AND " + drawHome + "       £" + df.format(profitEach(-stake,inplayHomeWin)) + "        £" + df.format(profitEach(inplayDrawWin,drawWin)) + "       £" + df.format(profitEach(awayWin,-stake))); 
		System.out.println(awayDraw + " AND " + drawAway + "       £" + -stake + "        £" + df.format(profitEach(inplayDrawWin,drawWin)) + "       £" + df.format(profitEach(awayWin,inplayAwayWin)));	
		System.out.println(awayHome + " AND " + drawHome + "       £" + (df.format(inplayHomeWin)) + "        £" + df.format(profitEach(-stake,drawWin)) + "       £" + df.format(profitEach(awayWin,-stake))); 
		System.out.println(awayHome + " AND " + drawAway + "       £" + df.format(profitEach(inplayHomeWin,-stake)) + "        £" + df.format(profitEach(-stake,drawWin)) + "       £" + df.format(profitEach(awayWin,inplayAwayWin)));		
		System.out.println(drawHome + " AND " + drawAway + "       £" + df.format(profitEach(inplayHomeWin,-stake)) + "        £" + df.format(drawWin) + "       £" + df.format(profitEach(-stake,inplayAwayWin)));
	}
	
}
