import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Numarare {
	public static void main(String[] args) {
		int numarNoduri = 0, numarMuchii = 0;
		List<Integer>[] graf1 = new List[0];
		List<Integer>[] graf2 = new List[0];

		try (BufferedReader br = new BufferedReader(new FileReader("numarare.in"))) {
			String[] linie = br.readLine().split(" ");
			numarNoduri = Integer.parseInt(linie[0]);
			graf1 = new ArrayList[numarNoduri + 1];
			graf2 = new ArrayList[numarNoduri + 1];
			numarMuchii = Integer.parseInt(linie[1]);

			for (int i = 1; i <= numarNoduri; i++) {
				graf1[i] = new ArrayList<>();
				graf2[i] = new ArrayList<>();
			}

			for (int i = 0; i < numarMuchii; i++) {
				String[] muchie = br.readLine().split(" ");
				int nod1 = Integer.parseInt(muchie[0]);
				int nod2 = Integer.parseInt(muchie[1]);
				graf1[nod1].add(nod2);
			}

			for (int i = 0; i < numarMuchii; i++) {
				String[] muchie = br.readLine().split(" ");
				int nod1 = Integer.parseInt(muchie[0]);
				int nod2 = Integer.parseInt(muchie[1]);
				graf2[nod1].add(nod2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Integer>[] intersectie = new ArrayList[numarNoduri + 1];
		int[] dp = new int[numarNoduri + 1];
		dp[1] = 1;

		for (int i = 1; i <= numarNoduri; i++) {
			intersectie[i] = new ArrayList<>();
		}

		for (int i = 1; i <= numarNoduri; i++) {
			for (int j = 0; j < graf1[i].size(); j++) {
				int vecin1 = graf1[i].get(j);
				for (int k = 0; k < graf2[i].size(); k++) {
					int vecin2 = graf2[i].get(k);
					if (vecin1 == vecin2) {
						intersectie[i].add(vecin1);
					}
				}
			}
		}

		for (int i = 1; i <= numarNoduri; i++) {
			if (dp[i] != 0) {
				for (int j = 0; j < intersectie[i].size(); j++) {
					int vecin = intersectie[i].get(j);
					dp[vecin] = (dp[vecin] + dp[i]) % 1_000_000_007;
				}
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("numarare.out"))) {
			bw.write(dp[numarNoduri] + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
