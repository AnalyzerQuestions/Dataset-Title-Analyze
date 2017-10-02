package br.edu.ifpb.analyserTitle.analysers;

import br.edu.ifpb.analyserTitle.util.StringTokenizerUtils;
import br.edu.ifpb.analyserTitle.util.StringUtil;

/**
 * 
 * <p>
 * <b> {@link TitleAnalyzer} </b>
 * </p>
 *
 * <p>
 * Analyser to title of question.
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class TitleAnalyzer {
	
	public Integer isMediumSizeTitle(String title) {
		String str = StringUtil.removeConnective(title);
		str = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(str);

		if (strPart.length > 2 && strPart.length <= 8)
			return 1;
		else
			return 0;
	}
	
	public Integer isSmallSizeTitle(String title) {
		String str = StringUtil.removeConnective(title);
		str = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(str);

		if (strPart.length <= 3)
			return 1;
		else
			return 0;
	}
	
	public Integer isTotallyUpperCase(String title){
		
		boolean result = title.equals(title.toUpperCase());
		
		if(result == true){
			return 1;
		}
		
		return 0;
	}
	
	public Integer isPartiallyUpperCase(String title){
		
		String str = StringUtil.removeConnective(title);
		str = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(str);
		
		int cont = 0;
		
		for(String s: strPart){
			if(s.equals(s.toUpperCase())){
				cont++;
			}
		}
		
		if(cont >= 2){
			return 1;
		}
		
		return 0;
	}

	public Integer containsHelpOrUrgent(String title){
		
		boolean result = title.contains("ajuda") || title.contains("urgente");
		
		if(result == true){
			return 1;
		}
		
		return 0;
	}
}
