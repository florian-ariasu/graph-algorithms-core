import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trenuri {
	private static void sortareTopologica(int nod, List<Integer>[] lista,
		List<Integer> sortat,	boolean[] vizitat) {
		vizitat[nod] = true;
		for (int i = 0; i < lista[nod].size(); i++) {
			int vecin = lista[nod].get(i);
			if (!vizitat[vecin]) {
				sortareTopologica(vecin, lista, sortat, vizitat);
			}
		}
		sortat.add(0, nod);
	}

	public static void main(String[] args) {
		String sursa = "", destinatie = "";
		int numarMuchii = 0;
		Map<String, Integer> orase = Map.of();
		List<Integer>[] lista = new List[0];

		try (BufferedReader br = new BufferedReader(new FileReader("trenuri.in"))) {
			String[] linie = br.readLine().split(" ");
			sursa = linie[0];
			destinatie = linie[1];
			linie = br.readLine().split(" ");
			numarMuchii = Integer.parseInt(linie[0]);
			lista = new ArrayList[numarMuchii];
			for (int i = 0; i < numarMuchii; i++) {
				lista[i] = new ArrayList<>();
			}

			orase = new HashMap<>();
			for (int i = 0; i < numarMuchii; i++) {
				String[] muchie = br.readLine().split(" ");
				String oras1 = muchie[0];
				String oras2 = muchie[1];
				orase.putIfAbsent(oras1, orase.size());
				orase.putIfAbsent(oras2, orase.size());
				lista[orase.get(oras1)].add(orase.get(oras2));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean[] vizitat = new boolean[orase.size()];
		List<Integer> sortat = new ArrayList<>();
		int[] distante = new int[orase.size()];
		sortareTopologica(orase.get(sursa), lista, sortat, vizitat);
		distante[orase.get(sursa)] = 1;

		for (int i = 0; i < sortat.size(); i++) {
			int nod = sortat.get(i);
			if (distante[nod] > 0) {
				for (int j = 0; j < lista[nod].size(); j++) {
					int vecin = lista[nod].get(j);
					distante[vecin] = Math.max(distante[vecin], distante[nod] + 1);
				}
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("trenuri.out"))) {
			bw.write(distante[orase.get(destinatie)] + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
