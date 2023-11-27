import java.util.LinkedList;

public class matrixImport {
	public static float calculateConfusing(String strPhrase, String strPhrase2) {
		LinkedList<String> newPhraseComp, retList;
		float[][] embeddings;
		float fConfusing;
		
		fConfusing=0;
		//Create new LinkedList
		retList = new LinkedList<String>();
		newPhraseComp = new LinkedList<String>();
		newPhraseComp.add(strPhrase);
		newPhraseComp.add(strPhrase2);
		
		embeddings = TensorflowHandler.getInstance().predict(newPhraseComp);
		
		for(int i=1;i<newPhraseComp.size();i++)
		{
			fConfusing = (float) cosineSimilarity(embeddings[0], embeddings[i]);
		}
		return fConfusing;
	}

	
	public static double cosineSimilarity(float[] vectorA, float[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }   
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
	public static int calculateNumPhrases(LinkedList<LinkedList<String>> lanPhrases)
	{
		int nRet;
		
		nRet = 0;
		if(lanPhrases != null)
		{
			for(LinkedList<String> lPhrases: lanPhrases)
			{
				for(String strPhrase: lPhrases)
				{
					nRet++;
				}
			}
		}
		return nRet;
	}
}
