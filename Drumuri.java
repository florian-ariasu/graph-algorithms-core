import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Drumuri {
	private static final long INF = 1_000_000_000_000_000_000L;

	private static void dijkstra(List<Pair<Integer, Integer>>[] lista, long[] distante,
		int nod) {
		PriorityQueue<Pair<Long, Integer>> coada =
			new PriorityQueue<>(Comparator.comparingLong(Pair::key));
		distante[nod] = 0;
		coada.add(new Pair<>(distante[nod], nod));

		while (!coada.isEmpty()) {
			Pair<Long, Integer> top = coada.poll();
			if (top.key() <= distante[top.value()]) {
				for (Pair<Integer, Integer> vecin : lista[top.value()]) {
					if (distante[top.value()] + vecin.value() < distante[vecin.key()]) {
						distante[vecin.key()] = distante[top.value()] + vecin.value();
						coada.add(new Pair<>(distante[top.value()] + vecin.value(),
							vecin.key()));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int numarNoduri = 0, numarMuchii = 0;
		int x = 0, y = 0, z = 0;
		List<Pair<Integer, Integer>>[] lista1 = new List[0];
		List<Pair<Integer, Integer>>[] lista2 = new List[0];

		try (BufferedReader br = new BufferedReader(new FileReader("drumuri.in"))) {
			String[] linie = br.readLine().split(" ");
			numarNoduri = Integer.parseInt(linie[0]);
			lista1 = new ArrayList[numarNoduri + 1];
			lista2 = new ArrayList[numarNoduri + 1];
			numarMuchii = Integer.parseInt(linie[1]);

			for (int i = 0; i <= numarNoduri; i++) {
				lista1[i] = new ArrayList<>();
				lista2[i] = new ArrayList<>();
			}

			for (int i = 0; i < numarMuchii; i++) {
				String[] muchie = br.readLine().split(" ");
				int nod1 = Integer.parseInt(muchie[0]);
				int nod2 = Integer.parseInt(muchie[1]);
				int cost = Integer.parseInt(muchie[2]);
				lista1[nod1].add(new Pair<>(nod2, cost));
				lista2[nod2].add(new Pair<>(nod1, cost));
			}

			linie = br.readLine().split(" ");
			x = Integer.parseInt(linie[0]);
			y = Integer.parseInt(linie[1]);
			z = Integer.parseInt(linie[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		final long[] distante1 = new long[numarNoduri + 1];
		final long[] distante2 = new long[numarNoduri + 1];
		final long[] distante3 = new long[numarNoduri + 1];
		Arrays.fill(distante1, INF);
		dijkstra(lista1, distante1, x);
		Arrays.fill(distante2, INF);
		dijkstra(lista1, distante2, y);
		Arrays.fill(distante3, INF);
		dijkstra(lista2, distante3, z);

		long rezultat = INF;
		for (int i = 1; i <= numarNoduri; i++) {
			rezultat = Math.min(rezultat, distante1[i] + distante2[i] + distante3[i]);
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("drumuri.out"))) {
			bw.write((rezultat == INF ? -1 : rezultat) + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	record Pair<K, V>(K key, V value) {
	}
}
