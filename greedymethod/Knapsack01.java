package greedymethod;
/**
 * @author Bengü Demireğen
 */
public class Knapsack01 {
	
	public static void EsyaSec(int esyasayisi, float[] agirlik, float[] deger, float kapasite) {
		
		float[] sonuc = new float[50];
		int i, guncelKapasite;

		guncelKapasite = (int) kapasite;

		for (i = 0; i < esyasayisi; i++)
			sonuc[i] = 0.0f;

		for (i = 0; i < esyasayisi; i++) {
			if (agirlik[i] > guncelKapasite)
				break;

			else {
				sonuc[i] = 1f;
				guncelKapasite = guncelKapasite - (int) agirlik[i]; 
																	
			}
		}

		if (i < esyasayisi)
			sonuc[i] = guncelKapasite / agirlik[i]; 	
													
		System.out.println("Eşya\t\tAğırlık\t\tDeğer");
		for (i = 0; i < esyasayisi; i++) 
		{
			System.out.println((i + 1) + "\t\t" + agirlik[i] + "\t\t" + deger[i]);
		}
		System.out.println("_________________________________________________________________________________________________");
		System.out.println("Sonuç:  ");
		System.out.print("{\t");
		
		for (i = 0; i < esyasayisi; i++)
			System.out.print(sonuc[i] + "\t");

		System.out.print("}");
	}

	public static void main(String[] args) {
		
		float agirlik[] = {1,2,3,4,5};
		float deger[] = {1,3,9,5,6};
		int kapasite = 8;
		int esyasayisi = deger.length;
		 
		float oran[] = new float[50];
		float temp;
		
		System.out.println("Eşya\t\tAğırlık\t\tDeğer");
		for (int i = 0; i < esyasayisi; i++) 
		{
			System.out.println((i + 1) + "\t\t" + agirlik[i] + "\t\t" + deger[i]);
		}
		System.out.println("Çantanın Kapasitesi: "+kapasite);

		for (int i = 0; i < esyasayisi; i++) {
			oran[i] = deger[i] / agirlik[i];
		}

		for (int i = 0; i < esyasayisi; i++) 
		{
			for (int j = i + 1; j < esyasayisi; j++) 
			{
				if (oran[i] < oran[j]) {
					temp = oran[j];
					oran[j] = oran[i];
					oran[i] = temp;

					temp = agirlik[j];
					agirlik[j] = agirlik[i];
					agirlik[i] = temp;

					temp = deger[j];
					deger[j] = deger[i];
					deger[i] = temp;
				}
			}
		}
		System.out.println("_________________________________________________________________");
		System.out.println("\nDeğer / Ağırlık oranı hesaplandı.\n");
		System.out.println("Eşyalar, oranları en büyükten en küçüğe olacak şekilde yeniden sıralandı. Dizi güncellendi. Dizideki eşyaların sıraları değişti.\n");
		System.out.println("Dizinin düzenlenmiş hali:\n");
		EsyaSec(esyasayisi, agirlik, deger, kapasite);
	}
}
