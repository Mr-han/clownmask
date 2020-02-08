jQuery(document).ready(function(){
    var scripts = document.getElementsByTagName("script");
    var jsFolder = "";
    for (var i= 0; i< scripts.length; i++)
    {
        if( scripts[i].src && scripts[i].src.match(/lovelygallery\.js/i))
            jsFolder = scripts[i].src.substr(0, scripts[i].src.lastIndexOf("/") + 1);
    }

    var $banner = $('#banner'),
        bannerW = $banner.width(),
        bannerH = $banner.height();

    jQuery("#html5zoo-1").html5zoo({
        jsfolder:jsFolder,
        width: bannerW,
        height:bannerH,
        unsliderheight: bannerH,
        skinsfoldername:"",
        loadimageondemand:false,
        isresponsive:false,
        autoplayvideo:false,
        pauseonmouseover:true,
        addmargin:true,
        randomplay:false,
        slideinterval:3000,
        enabletouchswipe:true,
        transitiononfirstslide:false,
        loop:0,
        autoplay:true,
        navplayvideoimage:"../images/bg/play-32-32-0.png",
        navpreviewheight:60,
        timerheight:2,
        shownumbering:false,
        skin:"Frontpage",
        addgooglefonts:true,
        navshowplaypause:true,
        navshowplayvideo:true,
        navshowplaypausestandalonemarginx:8,
        navshowplaypausestandalonemarginy:8,
        navbuttonradius:0,
        navthumbnavigationarrowimageheight:32,
        navmarginy:20,
        showshadow:false,
        navfeaturedarrowimagewidth:16,
        navpreviewwidth:120,
        googlefonts:"Inder",
        textpositionmarginright:24,
        bordercolor:"#ffffff",
        navthumbnavigationarrowimagewidth:32,
        navthumbtitlehovercss:"text-decoration:underline;",
        navcolor:"#999999",
        arrowwidth:48,
        texteffecteasing:"easeOutCubic",
        texteffect:"fade",
        navspacing:12,
        playvideoimage:"../images/bg/playvideo-64-64-0.png",
        ribbonimage:"../images/bg/ribbon_topleft-0.png",
        navwidth:0,
        showribbon:false,
        arrowimage:"../images/bg/arrows-48-48-3.png",
        timeropacity:0,
        navthumbnavigationarrowimage:"../images/bg/carouselarrows-32-32-0.png",
        navshowplaypausestandalone:false,
        navpreviewbordercolor:"#ffffff",
        ribbonposition:"topleft",
        navthumbdescriptioncss:"display:block;position:relative;padding:2px 4px;text-align:left;font:normal 12px Arial,Helvetica,sans-serif;color:#333;",
        arrowstyle:"mouseover",
        navthumbtitleheight:20,
        textpositionmargintop:24,
        navswitchonmouseover:false,
        navarrowimage:"../images/bg/navarrows-28-28-0.png",
        arrowtop:50,
        textstyle:"static",
        playvideoimageheight:64,
        navfonthighlightcolor:"#666666",
        showbackgroundimage:false,
        navpreviewborder:4,
        navopacity:0.8,
        shadowcolor:"#aaaaaa",
        navbuttonshowbgimage:true,
        navbuttonbgimage:"../images/bg/navbuttonbgimage-28-28-0.png",
        textbgcss:"display:block; position:absolute; top:0px; left:0px; width:100%; height:100%; background-color:#333333; opacity:0.6; filter:alpha(opacity=60);",
        navdirection:"horizontal",
        navborder:4,
        bottomshadowimagewidth:110,
        showtimer:true,
        navradius:0,
        navshowpreview:true,
        navpreviewarrowheight:8,
        navmarginx:16,
        navfeaturedarrowimage:"../images/bg/featuredarrow-16-8-0.png",
        navfeaturedarrowimageheight:8,
        navstyle:"bullets",
        textpositionmarginleft:24,
        descriptioncss:"display:block; position:relative; margin-top:4px; font:14px Inder,Arial,Tahoma,Helvetica,sans-serif; color:#fff;",
        navplaypauseimage:"../images/bg/navplaypause-28-28-0.png",
        backgroundimagetop:-10,
        timercolor:"#ffffff",
        numberingformat:"%NUM/%TOTAL ",
        navfontsize:12,
        navhighlightcolor:"#333333",
        navimage:"../images/bg/bullet-24-24-4.png",
        navheight:24,
        navshowplaypausestandaloneautohide:false,
        navbuttoncolor:"#999999",
        navshowarrow:true,
        navshowfeaturedarrow:false,
        titlecss:"display:block; position:relative; font:16px Inder,Arial,Tahoma,Helvetica,sans-serif; color:#fff;",
        ribbonimagey:0,
        ribbonimagex:0,
        navshowplaypausestandaloneposition:"bottomright",
        shadowsize:5,
        arrowhideonmouseleave:500,
        navshowplaypausestandalonewidth:28,
        navshowplaypausestandaloneheight:28,
        backgroundimagewidth:120,
        textautohide:true,
        navthumbtitlewidth:120,
        navpreviewposition:"top",
        playvideoimagewidth:64,
        arrowheight:48,
        arrowmargin:0,
        texteffectduration:bannerW,
        bottomshadowimage:"../images/bg/bottomshadow-110-100-5.png",
        border:0,
        timerposition:"bottom",
        navfontcolor:"#333333",
        navthumbnavigationstyle:"arrow",
        borderradius:0,
        navbuttonhighlightcolor:"#333333",
        textpositionstatic:"bottom",
        navthumbstyle:"imageonly",
        textcss:"display:block; padding:12px; text-align:left;",
        navbordercolor:"#ffffff",
        navpreviewarrowimage:"../images/bg/previewarrow-16-8-0.png",
        showbottomshadow:false,
        textpositionmarginstatic:0,
        backgroundimage:"",
        navposition:"bottom",
        navpreviewarrowwidth:16,
        bottomshadowimagetop:100,
        textpositiondynamic:"bottomleft",
        navshowbuttons:true,
        navthumbtitlecss:"display:block;position:relative;padding:2px 4px;text-align:left;font:bold 14px Arial,Helvetica,sans-serif;color:#333;",
        textpositionmarginbottom:24,
        ribbonmarginy:0,
        ribbonmarginx:0,
        slide: {
            duration:bannerW,
            easing:"easeOutCubic",
            checked:true
        },
        crossfade: {
            duration:bannerW,
            easing:"easeOutCubic",
            checked:true
        },
        threedhorizontal: {
            checked:true,
            bgcolor:"#222222",
            perspective:bannerW,
            slicecount:1,
            duration:1500,
            easing:"easeOutCubic",
            fallback:"slice",
            scatter:5,
            perspectiveorigin:"bottom"
        },
        slice: {
            duration:1500,
            easing:"easeOutCubic",
            checked:true,
            effects:"up,down,updown",
            slicecount:10
        },
        fade: {
            duration:bannerW,
            easing:"easeOutCubic",
            checked:true
        },
        blocks: {
            columncount:5,
            checked:true,
            rowcount:5,
            effects:"topleft,bottomright,top,bottom,random",
            duration:1500,
            easing:"easeOutCubic"
        },
        blinds: {
            duration:2000,
            easing:"easeOutCubic",
            checked:true,
            slicecount:3
        },
        shuffle: {
            duration:1500,
            easing:"easeOutCubic",
            columncount:5,
            checked:true,
            rowcount:5
        },
        threed: {
            checked:true,
            bgcolor:"#222222",
            perspective:bannerW,
            slicecount:5,
            duration:1500,
            easing:"easeOutCubic",
            fallback:"slice",
            scatter:5,
            perspectiveorigin:"right"
        },
        transition:"slide,slice,blocks,blinds,shuffle,threed,fade"
    });
});

$(function(){
  $('body').append('<div class="scroll-top hide"></div>');

  var $toTop = $('.scroll-top'),
    bannerH = $('#banner').height();

  $toTop.click(function(){
    $(window).scrollTop(0)
  });

  $(window).scroll(function(e){
    if($(this).scrollTop() > bannerH){
      $toTop.fadeIn();
    } else {
      $toTop.fadeOut();
    }
  })
})