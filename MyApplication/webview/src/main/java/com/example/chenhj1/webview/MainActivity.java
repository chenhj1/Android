package com.example.chenhj1.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String webStr = "<p>高手过招，表面波澜不惊，内里暗流涌动。美国《纽约时报》昨日刊文，详细记录了中美舰船上周在南海相遇的场景，双方通过无线电展开对话”，一来一回，每句话都充满内涵。</p><p style=\"text-align:center\"><img src=\"http://d.ifengimg.com/mw640_q75/y1.ifengimg.com/ifengimcp/pic/20160331/5e2b72a2421b227d21e9_size174_w1050_h591.jpg\" width=\"140\" /></p><p><small>美军钱斯勒斯维尔号战舰</small></p><p>上周，美国军舰钱斯勒斯维尔号驶入南海争议海域时，被中国护卫舰盯梢，中国护卫舰派出直升机，靠近美军。</p><p>美军少尉安东尼·吉安卡纳(Anthony Giancana)试图用无线电与中国直升机建立联系，“这是执勤美国海军舰艇，调频至121.5或243接收。”</p><p>中方没搭理。</p><p>这打乱了美军的节奏，中国直升机靠近后，舰长科尔特·A·伦肖(Capt. Curt A. Renshaw)上校这天早晨顾不上冲澡，直奔舰桥，跟诸位军官商议对策。</p><p>中国直升机绕着美军舰艇画圈，最终返回护卫舰，接着，中国护卫舰保持航向，继续向美军舰艇驶来</p><p style=\"text-align:center\"><img src=\"http://d.ifengimg.com/mw640_q75/y0.ifengimg.com/ifengimcp/pic/20160331/70cf8c66970ad414cae8_size51_w600_h400.jpg\" width=\"140\" /></p><p><small>美军舰长座椅旁的台子上，放着一本《简氏战舰》，书被翻到了第144页，介绍了各型中国护卫舰。</small></p><p>“你以前被跟过吗？”美军舰长询问导航员，貌似对他来说，被别国舰艇跟踪还是头一糟。他又转身问奈尔斯·李(Niles Li)海军少尉（编者注：应该是华裔），中国直升机为啥没有回应无线电信息，这位李少尉，是钱斯勒斯维尔号上仅有的说中文的军官之一。</p><p>中国护卫舰进入美军舰艇6英里（10公里）范围，清晰可见，这时，舰对舰无线电突然打破沉默，传出英语回复：“美国海军62舰。.....这是中国575舰。”</p><p>接下来，双方展开了一场微妙的互动。</p><p>“这是美国海军62舰。早上好，先生。今天海上天气不错，完毕。”</p><p>中方不搭理。</p><p>“这是美国海军62舰。早上好，先生。这是出海的好日子。完毕。”</p><p>中方还是不搭理。</p><p>舰长伦肖没招了，转向会中文的李少尉：“该你上了。他们不能装作不会说中文吧。”</p><p>“中国海军575舰，这是美国海军62舰，”李少尉用中文呼叫。“今天是海上航行的一个阳光灿烂的日子。完毕。”</p><p>好几分钟过去了。上午在甲板上执班的安东尼·吉安卡纳少尉变得坐立不安，嘴里念叨着：“我们已完成春训，这有点像大赛首日。”</p><p>突然，无线电报机再次响起，传来中文回应：“美国海军62舰，这是中国海军575舰。今天的天气很好，很高兴在海上遇到你。”</p><p>美军的李少尉接着说中文：“这是美国海军62舰。天气的确不错。也很高兴遇见你。完毕。”</p><p>突然画风一转，中国军舰改说英语：“你们从母港启程多久了？完毕。”</p><p>（就不陪你李少尉练中文了）</p><p>美军舰长立刻摇起头来。“不，我们不回答这个问题，我从不问他们这问题。”</p><p>美军舰长口风紧，担心泄露军事机密。</p><p>吉安卡纳少尉再次拿起了无线电：“中国海军575舰，这是美国海军62舰。我们不提航行日程。不过我们目前航行得很愉快。完毕。”</p><p>两艘军舰就这样在海上寒暄天气，为了检验中国是否在跟踪，钱斯勒斯维尔动了个小脑筋，转了个弯，美军观望中国舰艇下一步动作。</p><p>一位下级军官的喊了出来：“他刚才转舵了，长官！”</p><p>中国军舰决定陪美军“玩玩”。</p><p>“美国海军62舰，这是中国海军575舰，你们接下来会继续长期远航吗？完毕。”</p><p>美军内心大概又犯嘀咕了：这是不能说的秘密，可不能透露舰船的动向啊。</p><p>接下来美军的回应，让人怀疑连美国人都学会了“打太极”。</p><p>“这是美国海军62舰，”美军舰长回应，“收到，所有航程我们都不嫌长，因为不管离港多久，我们都享受海上的时光，完毕。”</p><p>与之形成对比的，是中国军舰的坦率，清者自清，就是要跟着你，瞧瞧你要搞什么小动作。</p><p>“美国海军62舰，这是中国海军575舰”，中国军舰答道，“明白，我将在未来几天随你一起航行。完毕。”</p><p>时间是上周二。周三，一艘中国驱逐舰接替护卫舰，继续监视美国军舰，一直到周四午夜、美国军舰离开南海。</p><p>（更多国外新鲜事儿，请关注[世界观]，微信搜索：shijieguan88）</p>";
    private String webUrl1 = "http://www.baidu.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
//        webView.loadData(webStr,"text/html;charset=UTF-8",null);
        webView.loadUrl("http://www.baidu.com/");

    }

    class MyWebviewClient extends WebViewClient{

    }
}
