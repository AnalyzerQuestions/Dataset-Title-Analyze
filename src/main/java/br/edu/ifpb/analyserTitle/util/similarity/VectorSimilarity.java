package br.edu.ifpb.analyserTitle.util.similarity;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * 		<b> Vector Similarity </b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */

/**
 * Modelo para representar um token de um texto e a frequencia de desse token
 * em um texto
 *
 */
public class VectorSimilarity {

	private Map<String, Float> vector;

	public VectorSimilarity() {
		vector = new HashMap<String, Float>();
	}

	public VectorSimilarity(Map<String, Float> vector) {
		vector = new HashMap<String, Float>();
		this.vector = vector;
	}

	public Map<String, Float> getVector() {

		return vector;
	}

	public void setVector(Map<String, Float> vector) {
		this.vector = vector;
	}

	public String toString() {
		return vector.toString();
	}
}
