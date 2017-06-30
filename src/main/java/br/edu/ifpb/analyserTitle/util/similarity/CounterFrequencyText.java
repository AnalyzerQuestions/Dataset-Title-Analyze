/**
 * 
  <p>
 * <b> Analyser Title </b>
 * </p>
 *
 * <p>
 * todos os direitos reservados
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.util.similarity;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.analyserTitle.util.LuceneUtil;
import br.edu.ifpb.analyserTitle.util.StringUtil;


/**
 * 
 * <p>
 * 		<b> Counter Frequency Text </b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class CounterFrequencyText {

	/**
	 * Obtém a frequencia de tokens de um texto
	 * 
	 * @param text
	 * @return
	 */
	public static VectorSimilarity getFrequency(String text) {

		String s0 = StringUtil.removeCharacterSpecial(text);
		String s1 = StringUtil.removerAcentos(s0);
		String s2 = StringUtil.removeConnective(s1);
		StringBuffer sb = new StringBuffer(s2);

		String aux = LuceneUtil.tokenizeString(sb).toString();
		String[] textTokens = aux.split(" ");
		Map<String, Float> frequencyText = new HashMap<String, Float>();

		if (textTokens.length != 0) {
			for (int i = 0; i < textTokens.length; i++) {

				String token = textTokens[i];
				Float frequency = frequencyText.get(token);

				if (frequency == null) {
					frequencyText.put(token, 1f);

				} else {
					frequencyText.put(token, frequency++);
				}
			}
			
			for (String s : frequencyText.keySet()) {
				frequencyText.put(s, (frequencyText.get(s) / textTokens.length));
			}
		}

		VectorSimilarity vector = new VectorSimilarity();
		vector.setVector(frequencyText);
		return vector;
	}
}
