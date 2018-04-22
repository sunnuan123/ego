<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EGO商城</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]> 
<link href="css/main.ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 7]> 
<link href="css/main.ie7.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery-imgslideshow.js"></script>
<script type="text/javascript" src="js/ks-switch.js"></script>
<script type="text/javascript" src="js/lib.js"></script>
<script type="text/javascript" src="js/portal.js"></script>
</head>

<body>
<div id="doc">
	<div id="s_hdw">
		<div id="s_tbar">
			<div class="s_hd">
				<div class="tbar_lft">您好，欢迎来到EGO商城！<a href="#">请登录</a> | <a href="#">免费注册</a></div>
				<div class="tbar_rgt">
					<ul>
						<li class="first"><a href="#">我的订单</a></li>
						<li><a href="#">我的EGO商城</a></li>
						<li><a href="#">帮助中心</a></li>
						<li><a href="#">联系客服</a></li>
						<li><a href="#">加入收藏</a></li>
						<li class="s_tel_str">服务热线：</li>
						<li class="s_tel">400-009-1906</li>
					</ul>
				</div>
			</div>
		</div><!--s_tbar end-->
		
		<div class="s_hd nav">
			<div id="s_logo"><a href="#"><img src="images/logo.png" border="0" /></a></div>
			<div id="s_nav">
				<ul>
					<li class="first cur"><a href="#">首页</a><span></span></li>
					<li><a href="#">积分兑换</a><span></span></li>
					<li><a href="#">抢购</a><span></span></li>
					<li class="last"><a href="#">礼品</a><span></span></li>
				</ul>
			</div>
		</div><!--s_hd end-->
		
		<div class="mmenu">
			<div class="s_hd">
				<div id="s_search">
					<form action="http://localhost:8082/search" method="get">
						<input name="charset" type="hidden" value="utf-8" class="search-input"/>
						<input name="keywords" type="text" class="search-input" />
						<input name="" type="image" src="images/btn_search.jpg" />
					</form>
				</div>
				
				<div id="s_keyword">
					<ul>
						<li><strong>热门搜索：</strong></li>
						<li><a href="#">贝玲妃</a></li>
						<li><a href="#">SKII</a></li>
						<li><a href="#">阿芙</a></li>
						<li><a href="#">罗莱家纺</a></li>
						<li><a href="#">glasslock</a></li>
						<li><a href="#">翡翠</a></li>
						<li><a href="#">珍珠</a></li>
						<li><a href="#">银饰</a></li>
						<li><a href="#">机械表</a></li>
					</ul>
				</div>
				
				<div id="s_cart">
					<ul>
						<li class="nums"><a href="" id="s_cart_nums1">购物车： <span>0</span>  件</a> <a href="" class="btn" id="s_cart_nums2"></a></li>
						<li class="checkout"><a href="#">去结算>></a></li>
					</ul>
				</div>
			
				<div id="s_cartbox" class="s_cartbox">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>
			
				<div id="s_cats">
					<div class="cat_hd"><h3><a href="#">所有商品分类</a></h3></div>
					<div class="cat_bd" style="display:block;">
					<ul id="menuList">
						
					</ul>
					</div>
				</div>
			</div>
		</div><!--mmenu end-->
	
	</div><!--s_hdw end-->
	
	<div id="s_bdw">
		<div id="s_bd">
			<div class="cf">
				<div id="i_col_lft" class="i_col_lft">
					<div class="categories"></div>
				</div>
				<div id="i_col_rgt" class="i_col_rgt">
					<div class="i_col_rgt_box">
					
						<div class="i_slides" id="slideshow">
						</div>
						
						<div class="pbt10"></div>
						
						<div class="lft">
							<div class="hotp">
								<div class="lft_icon"><a href="#"><span>pre</span></a></div>
								<div class="hot_list">
									<ul>
										<li><a href="#"><img src="images/f1.jpg" /></a></li>
										<li><a href="#"><img src="images/f2.jpg" /></a></li>
										<li><a href="#"><img src="images/f3.jpg" /></a></li>
										<li><a href="#"><img src="images/f4.jpg" /></a></li>
										<li><a href="#"><img src="images/f5.jpg" /></a></li>
										<li><a href="#"><img src="images/f6.jpg" /></a></li>
										<li><a href="#"><img src="images/f7.jpg" /></a></li>
										<li><a href="#"><img src="images/f8.jpg" /></a></li>
									</ul>
								</div>
								<div class="rgt_icon"><a href="#"><span>Nexr</span></a></div>
							</div>
						</div>
						
						<div class="rgt">
							<div class="rgt-box">
								<div class="loginbox">
									<div class="login_icon cf">
										<ul>
											<li><a href="#">免费注册</a></li>
											<li><a href="#">用户登录</a></li>
										</ul>
									</div>
									
									<div class="announce_top cf"><h3>关注EGO商城<span><a href="#">更多</a></span></h3></div>
								
									<div class="announce_cont">
										<ul>
											<li><a href="#">EGO商城迎国庆促销活动28号开始</a></li>
											<li><a href="#">迎中秋，上品轩专卖店开业</a></li>
											<li><a href="#">贺EGO商城全南店盛大开业</a></li>
											<li><a href="#">凡注册为EGO商城网上商城的会员</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					
				</div>
				
			</div>
			
			<div class="cf" id="cfIndex">
				
			</div>
			
			<div class="banner2 ptt10 cf"><a href="#"><img src="images/banner1.jpg" border="0" /></a></div>
		
			<div id="channel_0" class="i_channels cf">
				<div class="i_channels_tit">
					<div class="i_channels_cat_title"><h3 class="cf1">食品饮料</h3></div>
					<div class="i_channels_brand">
						<ul>
							<li class="first"><a href="#">康师傅</a></li>
							<li><a href="#">福临门</a></li>
							<li><a href="#">天喔</a></li>
							<li><a href="#">洽洽</a></li>
							<li><a href="#">卡夫</a></li>
							<li><a href="#">可口可乐</a></li>
							<li><a href="#">张裕</a></li>
							<li><a href="#">乐事</a></li>
							<li><a href="#">格力高</a></li>
							<li><a href="#">金龙鱼</a></li>
							<li><a href="#">更多</a></li>
						</ul>
					</div>
				</div>
				
				<div class="i_channels_cont">
					<div class="channel_lft">
						<div class="big_ad_box"><a href="#"><img src="images/cat_ad1.jpg" border="0" /></a></div>
					</div>
					
					<div class="channel_mid">
						<div class="cat_list_box">
							<ul>
								<li>
									<div class="cat_pd">
										<div class="pic"><a href="#"><img src="images/pd_1_1.jpg" border="0" /></a></div>
										<div class="ptitle"><a href="#">太平 加铁梳打奶盐口味400g 19元选2件</a></div>
										<div class="list_price">¥11.9</div>
										<div class="price">¥9.9</div>
									</div>
								</li>
								<li>
									<div class="cat_pd">
										<div class="pic"><a href="#"><img src="images/pd_1_2.jpg" border="0" /></a></div>
										<div class="ptitle"><a href="#">农夫山泉 维他命水美丽速度(石榴蓝莓风</a></div>
										<div class="list_price">¥30</div>
										<div class="price">¥20.8</div>
									</div>
								</li>
								<li>
									<div class="cat_pd">
										<div class="pic"><a href="#"><img src="images/pd_1_3.jpg" border="0" /></a></div>
										<div class="ptitle"><a href="#">丝宝宝 茶树菇145g/袋</a></div>
										<div class="list_price">¥26.5</div>
										<div class="price">¥20.4</div>
									</div>
								</li>
								<li>
									<div class="cat_pd">
										<div class="pic"><a href="#"><img src="images/pd_1_4.jpg" border="0" /></a></div>
										<div class="ptitle"><a href="#">梅林 午餐肉罐头 340g/罐</a></div>
										<div class="list_price">¥14.5</div>
										<div class="price">¥12.5</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				
					<div class="channel_rgt">
						<div class="small_ad_box">
							<ul>
								<li><a href="#"><img src="images/cat_s_ad1.jpg" border="0" /></a></li>
								<li><a href="#"><img src="images/cat_s_ad2.jpg" border="0" /></a></li>
								<li><a href="#"><img src="images/cat_s_ad3.jpg" border="0" /></a></li>
							</ul>
						</div>
					</div>
					
				</div>
				
			</div>
		
			<div id="channel_1" class="i_channels cf">
				<div class="i_channels_tit">
				<div class="i_channels_cat_title"><h3 class="cf2">美容护理</h3></div>
				<div class="i_channels_brand">
					<ul>
						<li class="first"><a href="#">欧莱雅</a></li>
						<li><a href="#">护舒宝</a></li>
						<li><a href="#">Hada</a></li>
						<li><a href="#">Labo肌研</a></li>
						<li><a href="#">玉兰油</a></li>
						<li><a href="#">相宜本草</a></li>
						<li><a href="#">曼秀雷敦</a></li>
						<li><a href="#">资生堂</a></li>
						<li><a href="#">苏菲</a></li>
						<li><a href="#">佳洁士</a></li>
						<li><a href="#">潘婷</a></li>
						<li><a href="#">更多</a></li>
					</ul>
				</div>
			</div>
			
			<div class="i_channels_cont">
				<div class="channel_lft">
					<div class="big_ad_box"><a href="#"><img src="images/cat_ad2.jpg" border="0" /></a></div>
				</div>
				<div class="channel_mid">
					<div class="cat_list_box">
						<ul>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat2-1.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">膜法世家1908 樱桃(车厘子)睡眠面膜100g</a></div>
									<div class="list_price">¥186</div>
									<div class="price">¥116</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat2-2.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">凌仕魅动男士香氛-契合</a></div>
									<div class="list_price">¥59</div>
									<div class="price">¥52.9</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat2-3.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">多芬日常损伤理护洗发乳400ml+润发精华素</a></div>
									<div class="list_price">¥65</div>
									<div class="price">¥55</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat2-4.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">德国爱姬玛琳经典香水沐浴露(100%原装进</a></div>
									<div class="list_price">¥58</div>
									<div class="price">¥38.6</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="channel_rgt">
					<div class="small_ad_box">
						<ul>
							<li><a href="#"><img src="images/cat_s_2-1.jpg" width="208" height="63" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_2-2.jpg" width="208" height="63" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad_2_3.jpg" width="203" height="98" border="0" /></a></li>
						</ul>
					</div>
				</div>
				
			</div>
			
		</div>
		
		<div id="channel_2" class="i_channels cf">
			<div class="i_channels_tit">
				<div class="i_channels_cat_title"><h3 class="cf3">母婴</h3></div>
				<div class="i_channels_brand">
					<ul>
						<li class="first"><a href="#">康师傅</a></li>
						<li><a href="#">福临门</a></li>
						<li><a href="#">天喔</a></li>
						<li><a href="#">洽洽</a></li>
						<li><a href="#">卡夫</a></li>
						<li><a href="#">可口可乐</a></li>
						<li><a href="#">张裕</a></li>
						<li><a href="#">乐事</a></li>
						<li><a href="#">格力高</a></li>
						<li><a href="#">金龙鱼</a></li>
						<li><a href="#">更多</a></li>
					</ul>
				</div>
			</div>
		
			<div class="i_channels_cont">
				<div class="channel_lft">
					<div class="big_ad_box"><a href="#"><img src="images/cat_ad3.jpg" border="0" /></a></div>
				</div>
				
				<div class="channel_mid">
					<div class="cat_list_box">
						<ul>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat3-1.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">太平 加铁梳打奶盐口味400g 19元选2件</a></div>
									<div class="list_price">¥11.9</div>
									<div class="price">¥9.9</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat3-2.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">农夫山泉 维他命水美丽速度(石榴蓝莓风</a></div>
									<div class="list_price">¥30</div>
									<div class="price">¥20.8</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat3-3.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">丝宝宝 茶树菇145g/袋</a></div>
									<div class="list_price">¥26.5</div>
									<div class="price">¥20.4</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat3-4.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">梅林 午餐肉罐头 340g/罐</a></div>
									<div class="list_price">¥14.5</div>
									<div class="price">¥12.5</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="channel_rgt">
					<div class="small_ad_box">
						<ul>
							<li><a href="#"><img src="images/cat_s_ad3-1.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad3-2.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad3-3.jpg" border="0" /></a></li>
						</ul>
					</div>
				</div>
			
			</div>
		</div>
		
		<div id="channel_3" class="i_channels cf">
			<div class="i_channels_tit">
				<div class="i_channels_cat_title"><h3 class="cf4">厨卫清洁</h3></div>
				<div class="i_channels_brand">
					<ul>
						<li class="first"><a href="#">康师傅</a></li>
						<li><a href="#">福临门</a></li>
						<li><a href="#">天喔</a></li>
						<li><a href="#">洽洽</a></li>
						<li><a href="#">卡夫</a></li>
						<li><a href="#">可口可乐</a></li>
						<li><a href="#">张裕</a></li>
						<li><a href="#">乐事</a></li>
						<li><a href="#">格力高</a></li>
						<li><a href="#">金龙鱼</a></li>
						<li><a href="#">更多</a></li>
					</ul>
				</div>
			</div>
			
			<div class="i_channels_cont">
				<div class="channel_lft">
					<div class="big_ad_box"><a href="#"><img src="images/cat_ad4.jpg" border="0" /></a></div>
				</div>
				
				<div class="channel_mid">
					<div class="cat_list_box">
						<ul>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat4-1.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">太平 加铁梳打奶盐口味400g 19元选2件</a></div>
									<div class="list_price">¥11.9</div>
									<div class="price">¥9.9</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat4-2.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">农夫山泉 维他命水美丽速度(石榴蓝莓风</a></div>
									<div class="list_price">¥30</div>
									<div class="price">¥20.8</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat4-3.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">丝宝宝 茶树菇145g/袋</a></div>
									<div class="list_price">¥26.5</div>
									<div class="price">¥20.4</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/cat4-4.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">梅林 午餐肉罐头 340g/罐</a></div>
									<div class="list_price">¥14.5</div>
									<div class="price">¥12.5</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="channel_rgt">
					<div class="small_ad_box">
						<ul>
							<li><a href="#"><img src="images/cat_s_ad4-1.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad4-2.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad4-3.jpg" border="0" /></a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
		
		<div id="channel_4" class="i_channels cf">
			<div class="i_channels_tit">
				<div class="i_channels_cat_title"><h3 class="cf5">家居</h3></div>
				<div class="i_channels_brand">
					<ul>
						<li class="first"><a href="#">康师傅</a></li>
						<li><a href="#">福临门</a></li>
						<li><a href="#">天喔</a></li>
						<li><a href="#">洽洽</a></li>
						<li><a href="#">卡夫</a></li>
						<li><a href="#">可口可乐</a></li>
						<li><a href="#">张裕</a></li>
						<li><a href="#">乐事</a></li>
						<li><a href="#">格力高</a></li>
						<li><a href="#">金龙鱼</a></li>
						<li><a href="#">更多</a></li>
					</ul>
				</div>
			</div>
			
			<div class="i_channels_cont">
				<div class="channel_lft">
					<div class="big_ad_box"><a href="#"><img src="images/cat_ad5.jpg" border="0" /></a></div>
				</div>
				
				<div class="channel_mid">
					<div class="cat_list_box">
						<ul>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/pd_1_1.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">太平 加铁梳打奶盐口味400g 19元选2件</a></div>
									<div class="list_price">¥11.9</div>
									<div class="price">¥9.9</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/pd_1_2.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">农夫山泉 维他命水美丽速度(石榴蓝莓风</a></div>
									<div class="list_price">¥30</div>
									<div class="price">¥20.8</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/pd_1_3.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">丝宝宝 茶树菇145g/袋</a></div>
									<div class="list_price">¥26.5</div>
									<div class="price">¥20.4</div>
								</div>
							</li>
							<li>
								<div class="cat_pd">
									<div class="pic"><a href="#"><img src="images/pd_1_4.jpg" border="0" /></a></div>
									<div class="ptitle"><a href="#">梅林 午餐肉罐头 340g/罐</a></div>
									<div class="list_price">¥14.5</div>
									<div class="price">¥12.5</div>
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div class="channel_rgt">
					<div class="small_ad_box">
						<ul>
							<li><a href="#"><img src="images/cat_s_ad5-1.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad5-2.jpg" border="0" /></a></li>
							<li><a href="#"><img src="images/cat_s_ad5-3.jpg" border="0" /></a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
		
		</div>
	</div><!--s_bdw end-->	
	
	<div id="s_ftw">
	
		<div class="ft_quicklinks">
			<div class="ftql cf">
				<ul>
					<li class="ftql_s">
						<h3>购物指南</h3>
						<ul>
							<li><a href="">怎样购物</a></li>
							<li><a href="">会员制</a></li>
							<li><a href="">积分制度</a></li>
							<li><a href="">优惠券介绍</a></li>
							<li><a href="">订单状态说明</a></li>
						</ul>
					</li>
					<li class="ftql_s">
						<h3>服务条款</h3>
						<ul>
							<li><a href="">售后条款</a></li>
							<li><a href="">退换货说明</a></li>
							<li><a href="">联系客服</a></li>
						</ul>
					</li>
					<li class="ftql_s">
						<h3>配送方式</h3>
						<ul>
							<li><a href="">上门自提</a></li>
							<li><a href="">快递运输</a></li>
							<li><a href="">特快专递（EMS）</a></li>
							<li><a href="">如何送礼</a></li>
						</ul>
					</li>
					<li class="ftql_s">
						<h3>支付帮助</h3>
						<ul>
							<li><a href="">货到付款</a></li>
							<li><a href="">在线支付</a></li>
							<li><a href="">邮政汇款</a></li>
							<li><a href="">银行转账</a></li>
							<li><a href="">发票说明</a></li>
						</ul>
					</li>
					<li class="ftql_s">
						<h3>关于EGO商城</h3>
						<ul>
							<li><a href="">EGO商城介绍</a></li>
							<li><a href="">团队</a></li>
							<li><a href="">媒体报道</a></li>
							<li><a href="">招纳贤士</a></li>
							<li><a href="">公告</a></li>
						</ul>
					</li>
					<li class="ftql_s">
						<div class="ftql_d">
							<div class="str">客服中心信箱：</div>
							<div class="val"><a href="mailto:service@shunkelong.com">1248452992@qq.com</a></div>
						</div>
						<div class="ftql_d">
							<div class="str">客服中心热线：</div>
							<div class="val stel">400-009-1906</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	
		<div id="s_ft">
			<div class="ft_suggest pt100">请帮助我们提高！<a href="#">商城首页意见反馈</a></div>
			<div class="ft_banners1 tac pbt10">
				<ul>
					<li><a href="#"><img src="images/ft_1.gif" border="0" /></a></li>
					<li><a href="#"><img src="images/ft_2.gif" border="0" /></a></li>
					<li><a href="#"><img src="images/ft_3.gif" border="0" /></a></li>
				</ul>
			</div>
			<div class="copyright tac pbt10">版权所有 Copyright&copy; EGO商城 All Rights Reserved 版权所有 </div>
			<div class="ft_banners2 tac">
				<ul>
					<li><a href="#"><img src="images/u255.png" border="0" /></a></li>
					<li><a href="#"><img src="images/u257.png" border="0" /></a></li>
					<li><a href="#"><img src="images/u259.png" border="0" /></a></li>
					<li><a href="#"><img src="images/u261.png" border="0" /></a></li>
				</ul>
			</div>
		</div>
		
	</div><!--s_ftw end-->

</div>
</body>
<script type="text/javascript">
	$(function(){
		findAllMenu();
		findAllSide();
		findCfIndex();
	});
	
	function findCfIndex(){
		$.ajax({
			url:"http://localhost:8080/content/findCfIndex",
			dataType:"jsonp",
			jsonp:"callBack",
			success:function(res){
				var htmlStr = "";
				$.each(res, function(i,v){
					htmlStr+=v;
				});
				$("#cfIndex").html(htmlStr);
				$("#slide-qg").switchTab({titCell: "dt a", trigger: "mouseover", delayTime: 0});
			}
		});
	}
	
	function findAllSide(){
		$.ajax({
			url:"http://localhost:8080/content/findSlideIndex",
			dataType:"jsonp",
			jsonp:"callBack",
			success:function(res){
				var htmlStr='';
				$.each(res, function(i, v){
					htmlStr += '<div class="i"><a href="'+v.url+'"><img src="'+v.picUrl+'" /></a></div>';
				});
				$("#slideshow").html(htmlStr);
				//调用轮播扩展函数
				$('#slideshow').imgSlideShow({itemclass: 'i'});
				$("#slide-qg").switchTab({titCell: "dt a", trigger: "mouseover", delayTime: 0});
			}
		});
		
	}
	
	function findAllMenu(){
		$.ajax({
			url:"http://localhost:8080/goods/cat/findAllMenu",
			dataType:"jsonp",
			jsonp:"callBack",
			success:function(res){
				//拼接字符串
				var htmlStr = '';
				$.each(res,function(i,v1){
					htmlStr += '<li class="cat_item">';
					htmlStr += '<h4 class="cat_tit">';
					htmlStr += '<a href="#" class="cat_tit_link">'+v1.name+'</a><span class="s_arrow">></span></h4>';
					htmlStr += '<div class="cat_cont">';
					htmlStr += '<div class="cat_cont_lft">';
					
					$.each(v1.menuCateNameList,function(j,v2){
						htmlStr += '<dl class="cf">';
						htmlStr += '<dt><a href="#">'+v2.name+'</a></dt>';
						htmlStr += '<dd>';
						htmlStr += '<ul>';
						$.each(v2.menuCateNameList,function(k,v3){
							if(k==0){
								htmlStr += '<li class="first"><a href="#">'+v3.name+'</a></li>';
							}else{
								htmlStr += '<li><a href="#">'+v3.name+'</a></li>';
							}
						});
						htmlStr += '</ul>';
						htmlStr += '</dd>';
						htmlStr += '</dl>';
					});
					
					htmlStr += '</div>';
					htmlStr += '</div>';
					htmlStr += '</li>';
				});
				
				$("#menuList").html(htmlStr);
				//添加鼠标移入移除时间
				$('.cat_item').mousemove(function(){
					$(this).addClass('cat_item_on');
				});
				$('.cat_item').mouseleave(function(){	
					$(this).removeClass('cat_item_on');
				});
			}
		});
	}
</script>

</html>
