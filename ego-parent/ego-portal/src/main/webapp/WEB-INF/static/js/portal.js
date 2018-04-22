var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;

$(document).ready(function(){
   	$('.cat_item').mousemove(function(){
		$(this).addClass('cat_item_on');
	});
	$('.cat_item').mouseleave(function(){	
		$(this).removeClass('cat_item_on');
	});
	$('#slideshow').imgSlideShow({itemclass: 'i'})
	$("#slide-qg").switchTab({titCell: "dt a", trigger: "mouseover", delayTime: 0});
	$("#s_cart_nums1").hover(function(){
		mcancelclosetime();
		if(ddmenuitem) ddmenuitem.hide();
		ddmenuitem = $(document).find("#s_cartbox");
		ddmenuitem.fadeIn();
	},function(){
		mclosetime();
	});
	$("#s_cart_nums2").hover(function(){
		mcancelclosetime();
		if(ddmenuitem) ddmenuitem.hide();
		ddmenuitem = $(document).find("#s_cartbox");
		ddmenuitem.fadeIn();
	},function(){
		mclosetime();
	});
	$("#s_cartbox").hover(function(){
		mcancelclosetime();
	},function(){
		mclosetime();
	});
	 var $cur = 1;
    var $i = 4;
    var $len = $('.hot_list>ul>li').length;
    var $pages = Math.ceil($len / $i);
    var $w = $('.hotp').width()-66;
	
    var $showbox = $('.hot_list');
    
    var $pre = $('div.left_icon');
    var $next = $('div.rgt_icon');
 	
    $pre.click(function(){
        if (!$showbox.is(':animated')) { 
            if ($cur == 1) {   
                $showbox.animate({
                    left: '-=' + $w * ($pages - 1)
                }, 500); 
                $cur = $pages; 
            }
            else { 
                $showbox.animate({
                    left: '+=' + $w
                }, 500); 
                $cur--;
            }
           
        }
    });

    $next.click(function(){
        if (!$showbox.is(':animated')) { 
            if ($cur == $pages) {  
                $showbox.animate({
                    left: 0
                }, 500); 
                $cur = 1; 
            }
            else {
                $showbox.animate({
                    left: '-=' + $w
                }, 500);
                $cur++; 
            }
            
        }
    });
    
});
function mclose()
{
	if(ddmenuitem) ddmenuitem.hide();
}
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
}
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}