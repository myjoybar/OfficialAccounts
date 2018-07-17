package com.joy.wechat.content;

import java.util.HashMap;
import java.util.Map;

public class TextContentDes {

	public static final String MENU_1 = 1+"";
	public static final String MENU_2 = 2+"";
	public static final String MENU_3 = 3+"";
	public static final String MENU_4 = 4+"";
	public static final String MENU_5 = 5+"";
	
	public static final String MENU_1_CONTENT = "1. 坚持写博客\n2. 在GitHub上参与开源项目\n3. 有自己的完整作品\n4. 阅读Android源码，理解一些高级概念";
	public static final String MENU_2_CONTENT = "《周易》是我国一部古老的典籍，其流传已有近三千年的历史。在春秋战国时代，就已被人们视为重要的典籍，以后在长期的封建社会中，一直被尊奉为神圣的经典，其影响之深远，在世界历史上是少见的。《周易》最初是占筮用的一部迷信的书，可是后来随着对它的解释，演变为一部讲哲理的书。从汉朝开始，由于儒家经学的确立和发展，《周易》被儒家吸收列为儒家五经之首，人们对它的研究，成了一种专门的学问，即易学。";
	public static final String MENU_3_CONTENT = "观自在菩萨，行深般若波罗蜜多时，照见五蕴皆空，度一切苦厄。舍利子，色不异空，空不异色，色即是空，空即是色，受想行识，亦复如是。舍利子，是诸法空相，不生不灭，不垢不净，不增不减。是故空中无色，无受想行识，无眼耳鼻舌身意，无色声香味触法，无眼界，乃至无意识界。无无明，亦无无明尽，乃至无老死，亦无老死尽。无苦集灭道，无智亦无得。以无所得故，菩提萨埵，依般若波罗蜜多故，心无罣碍，无罣碍故，无有恐怖，远离颠倒梦想，究竟涅磐。三世诸佛，依般若波罗蜜多故，得阿耨多罗三藐三菩提。故知般若波罗蜜多，是大神咒，是大明咒，是无上咒，是无等等咒，能除一切苦，真实不虚。故说般若波罗蜜多咒，即说咒曰：揭谛揭谛波罗揭谛波罗僧揭谛菩提萨婆诃。";
	public static final String MENU_4_CONTENT = "围绕我们生命中的文化现象、生活、美学及思想等种种课题抒发情怀";
	public static final String MENU_5_CONTENT = "随笔感悟";
	
	public static Map<String, String> MAP_MENU_CONTENT = new HashMap<String, String>();

	static{
		MAP_MENU_CONTENT.put(MENU_1, MENU_1_CONTENT);
		MAP_MENU_CONTENT.put(MENU_2, MENU_2_CONTENT);
		MAP_MENU_CONTENT.put(MENU_3, MENU_3_CONTENT);
		MAP_MENU_CONTENT.put(MENU_4, MENU_4_CONTENT);
		MAP_MENU_CONTENT.put(MENU_5, MENU_5_CONTENT);
	}
}
