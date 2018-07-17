package com.joy.wechat.servlet;

import com.joy.wechat.content.TextContentDes;
import com.joy.wechat.utils.CheckUtil;
import com.joy.wechat.utils.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class WeixinServlet extends HttpServlet implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public WeixinServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			String signature = req.getParameter("signature");
			String timestamp = req.getParameter("timestamp");
			String nonce = req.getParameter("nonce");
			String echostr = req.getParameter("echostr");
			PrintWriter out = resp.getWriter();

			System.out.println("signature=" + signature);
			System.out.println("timestamp=" + timestamp);
			System.out.println("nonce=" + nonce);
			System.out.println("echostr=" + echostr);

			if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
		} catch (Exception e) {
			resp.getWriter().write("server error,please try again later");
		} finally {
			if (null != resp.getWriter()) {
				resp.getWriter().close();
			}

		}

		System.out.println("doGet");
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
      
		
		
		
		try {

			Map<String, String> map = MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String message = null;

			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				// 文本消息

				if (TextContentDes.MENU_1.equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							TextContentDes.MAP_MENU_CONTENT.get(content));
				} else if (TextContentDes.MENU_2.equals(content)) {
					 message = MessageUtil.initText(toUserName, fromUserName,
					 TextContentDes.MAP_MENU_CONTENT.get(content));
				
				} else if (TextContentDes.MENU_3.equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							TextContentDes.MAP_MENU_CONTENT.get(content));
				} else if (TextContentDes.MENU_4.equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							TextContentDes.MAP_MENU_CONTENT.get(content));
				} else if (TextContentDes.MENU_5.equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							TextContentDes.MAP_MENU_CONTENT.get(content));
				} else if ("?".equals(content) || "？".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.menuText());
				} else if ("6".equals(content)) {
					// 测试图文消息
					message = MessageUtil.initNewsMessage(toUserName,
							fromUserName);
				} else if ("7".equals(content)) {
					// 测试图片消息
					message = MessageUtil.initImageMessage(toUserName,
							fromUserName);
				}else {
					message = MessageUtil.initText(toUserName, fromUserName,
							"回复？显示帮助菜单");
				}

			

			} else if (MessageUtil.MESSAGE_EVNET.equals(msgType)) {
				// 事件
				String eventType = map.get("Event");
				System.out.println("eventType=" + eventType);
				// 订阅
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_CLICK.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_VIEW.equals(eventType)) {
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName,
							url);
				} else if (MessageUtil.MESSAGE_SCANCODE.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName,
							key);
//				}else if (MessageUtil.MESSAGE_LOCATION.equals(eventType)) {
//					String label = map.get("Lable");
//					message = MessageUtil.initText(toUserName, fromUserName,
//							label);
				}
			}
			System.out.println("message=" + message);
			out.print(message);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			out.close();
		}
	}
}
