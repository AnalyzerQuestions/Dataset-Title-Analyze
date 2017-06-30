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
package br.edu.ifpb.analyserTitle.entities;

import java.io.Serializable;

/**
 * 
 * <p>
 * <b> {@link Question} </b>
 * </p>
 *
 * <p>
 * Entidade que representa um pergunta.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class Question implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String body;
	private String link;
	
	public Question() {
	}

	public Question(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", body=" + body
				+ ", link=" + link + "]";
	}
}
