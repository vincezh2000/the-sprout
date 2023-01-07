package com.example.final_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class TopMovieDetail extends AppCompatActivity {
    int[] imageID=new int[]{R.mipmap.img2_12,R.mipmap.img2_22,R.mipmap.img2_32,R.mipmap.img2_42,R.mipmap.img2_51,R.mipmap.img2_62,R.mipmap.img2_72,R.mipmap.img2_82,R.mipmap.img2_92,R.mipmap.img2_102};
    ImageView img;
    RatingBar rb2;
    ImageView btn2;
    String[] jjs=new String[]{"一场谋杀案使银行家安迪（蒂姆•罗宾斯 Tim Robbins 饰）蒙冤入狱，谋杀妻子及其情人的指控将囚禁他终生。在肖申克监狱的首次现身就让监狱“大哥”瑞德（摩根•弗里曼 Morgan Freeman 饰）对他另眼相看。瑞德帮助他搞到一把石锤和一幅女明星海报，两人渐成患难 之交。很快，安迪在监狱里大显其才，担当监狱图书管理员，并利用自己的金融知识帮助监狱官避税，引起了典狱长的注意，被招致麾下帮助典狱长洗黑钱。偶然一次，他得知一名新入狱的小偷能够作证帮他洗脱谋杀罪。燃起一丝希望的安迪找到了典狱长，希望他能帮自己翻案。阴险伪善的狱长假装答应安迪，背后却派人杀死小偷，让他唯一能合法出狱的希望泯灭。沮丧的安迪并没有绝望，在一个电闪雷鸣的风雨夜，一场暗藏几十年的越狱计划让他自我救赎，重获自由！老朋友瑞德在他的鼓舞和帮助下，也勇敢地奔向自由。",
            "段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。 段小楼在认为该成家立业之时迎娶了名妓菊仙（巩俐），致使程蝶衣认定菊仙是可耻的第三者，使段小楼做了叛徒，自此，三人围绕一出《霸王别姬》生出的爱恨情仇战开始随着时代风云的变迁不断升级，终酿成悲剧。",
            "阿甘（汤姆·汉克斯 饰）于二战结束后不久出生在美国南方阿拉巴马州一个闭塞的小镇，他先天弱智，智商只有75，然而他的妈妈是一个性格坚强的女性，她常常鼓励阿甘“傻人有傻福”，要他自强不息。 阿甘像普通孩子一样上学，并且认识了一生的朋友和至爱珍妮（罗宾·莱特·潘 饰），在珍妮 和妈妈的爱护下，阿甘凭着上帝赐予的“飞毛腿”开始了一生不停的奔跑。 阿甘成为橄榄球巨星、越战英雄、乒乓球外交使者、亿万富翁，但是，他始终忘不了珍妮，几次匆匆的相聚和离别，更是加深了阿甘的思念。 有一天，阿甘收到珍妮的信，他们终于又要见面…",
            "里昂（让·雷诺饰）是名孤独的职业杀手，受人雇佣。一天，邻居家小姑娘马蒂尔达（纳塔丽·波特曼饰)敲开他的房门，要求在他那里暂避杀身之祸。原来邻居家的主人是警方缉毒组的眼线，只因贪污了一小包毒品而遭恶警（加里·奥德曼饰）杀害全家的惩罚。马蒂尔达得到里昂的留救，幸免于难，并留在里昂那里。里昂教小女孩使枪，她教里昂法文，两人关系日趋亲密，相处融洽。 女孩想着去报仇，反倒被抓，里昂及时赶到，将女孩救回。混杂着哀怨情仇的正邪之战渐次升级，更大的冲突在所难免……",
            "1912年4月10日，号称 “世界工业史上的奇迹”的豪华客轮泰坦尼克号开始了自己的处女航，从英国的南安普顿出发驶往美国纽约。富家少女罗丝（凯特•温丝莱特）与母亲及未婚夫卡尔坐上了头等舱；另一边，放荡不羁的少年画家杰克（莱昂纳多·迪卡普里奥）也在码头的一场赌博中赢得了下等舱的船票。 罗丝厌倦了上流社会虚伪的生活，不愿嫁给卡尔，打算投海自尽，被杰克救起。很快，美丽活泼的罗丝与英俊开朗的杰克相爱，杰克带罗丝参加下等舱的舞会、为她画像，二人的感情逐渐升温。 1912年4月14日，星期天晚上，一个风平浪静的夜晚。泰坦尼克号撞上了冰山，“永不沉没的”泰坦尼克号面临沉船的命运，罗丝和杰克刚萌芽的爱情也将经历生死的考验。",
            "犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” 法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？",
            "千寻和爸爸妈妈一同驱车前往新家，在郊外的小路上不慎进入了神秘的隧道——他们去到了另外一个诡异世界—一个中世纪的小镇。远处飘来食物的香味，爸爸妈妈大快朵颐，孰料之后变成了猪！这时小镇上渐渐来了许多样子古怪、半透明的人。千寻仓皇逃出，一个叫小白的人救了他，喂了她阻止身体消 失的药，并且告诉她怎样去找锅炉爷爷以及汤婆婆，而且必须获得一份工作才能不被魔法变成别的东西。千寻在小白的帮助下幸运地获得了一份在浴池打杂的工作。渐渐她不再被那些怪模怪样的人吓倒，并从小玲那儿知道了小白是凶恶的汤婆婆的弟子。一次，千寻发现小白被一群白色飞舞的纸人打伤，为了救受伤的小白，她用河神送给她的药丸驱出了小白身体内的封印以及守封印的小妖精，但小白还是没有醒过来。为了救小白，千寻又踏上了她的冒险之旅。",
            "1939年，波兰在纳粹德国的统治下，党卫军对犹太人进行了隔离统治。德国商人奥斯卡·辛德勒（连姆·尼森 Liam Neeson 饰）来到德军统治下的克拉科夫，开设了一间搪瓷厂，生产军需用品。凭着出众的社交能力和大量的金钱，辛德勒和德军建立了良好的关系，他的工厂雇用犹太人工作，大发战争财。1943年，克拉科夫的犹太人遭到了惨绝人寰的大屠杀，辛德勒目睹这一切，受到了极大的震撼，他贿赂军官，让自己的工厂成为集中营的附属劳役营，在那些疯狂屠杀的日子里，他的工厂也成为了犹太人的避难所。1944年，德国战败前夕，屠杀犹太人的行动越发疯狂，辛德勒向德军军官开出了1200人的名单，倾家荡产买下了这些犹太人的生命。在那些暗无天日的岁月里，拯救一个人，就是拯救全世界。",
            "道姆·柯布（莱昂纳多·迪卡普里奥 Leonardo DiCaprio 饰）与同事阿瑟（约瑟夫·戈登-莱维特 Joseph Gordon-Levitt 饰）和纳什（卢卡斯·哈斯 Lukas Haas 饰）在一次针对日本能源大亨齐藤（渡边谦 饰）的盗梦行动中失败，反被齐藤利用。齐藤威逼利诱因遭通缉而流亡海外的柯布帮他拆分他竞争对手的公司，采取极端措施在其唯一继承人罗伯特·费希尔（希里安·墨菲 Cillian Murphy 饰）的深层潜意识中种下放弃家族公司、自立门户的想法。为了重返美国，柯布偷偷求助于岳父迈尔斯（迈克尔·凯恩 Michael Caine 饰），吸收了年轻的梦境设计师艾里阿德妮（艾伦·佩吉 Ellen Page 饰）、梦境演员艾姆斯（汤姆·哈迪 Tom Hardy 饰）和药剂师约瑟夫（迪利普·劳 Dileep Rao 饰）加入行动。在一层层递进的梦境中，柯布不仅要对付费希尔潜意识的本能反抗，还必须直面已逝妻子梅尔（玛丽昂·歌迪亚 Marion Cotillard 饰）的处处破坏，实际情况远比预想危险得多……",
            "八公（Forest 饰）是一条谜一样的犬，因为没有人知道它从哪里来。教授帕克（理查·基尔 Richard Gere 饰）在小镇的火车站拣到一只走失的小狗，冥冥中似乎注定小狗和帕克教授有着某种缘分，帕克一抱起这只小狗就再也放不下来，最终，帕克对小狗八公的疼爱感化了起初极力反对养狗的妻子卡特（琼·艾伦 Joan Allen 饰）。八公在帕克的呵护下慢慢长大，帕克上班时八公会一直把他送到车站，下班时八公也会早早便爬在车站等候，八公的忠诚让小镇的人家对它更加疼爱。有一天，八公在帕克要上班时表现异常，居然玩起了以往从来不会的捡球游戏，八公的表现让帕克非常满意，可是就是在那天，帕克因病去世。帕克的妻子、女儿安迪（萨拉·罗默尔 Sarah Roemer 饰）及女婿迈克尔（罗比·萨布莱特 Robbie Sublett 饰）怀着无比沉痛的心情埋葬了帕克，可是不明就里的八公却依然每天傍晚五点准时守候在小站的门前，等待着主人归来……本片根据上个世纪30年代发生在日本的真实故事改编，1987年在日本拍成电影后创造了40亿日元的票房。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movie_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        img = (ImageView) findViewById(R.id.iv_img1);
        rb2 = (RatingBar) findViewById(R.id.rb2);
        btn2 = (ImageView) findViewById(R.id.btn2);
        TextView intro1 = (TextView) findViewById(R.id.tv_jianjie1);
        int no2 = bundle.getInt("position");
        img.setImageResource(imageID[no2]);

        intro1.setText(jjs[no2]);

//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("test_db", null);
//        Cursor cursor = db.query("usertable", null, null, null, null, null, null);
//        String intro02;
//        //判断游标是否为空
//        if (cursor.moveToFirst()) {
//            //遍历游标
//            for (int i = 0; i < cursor.getCount(); i++) {
//                cursor.move(i);
//                intro02 = cursor.getString(2);
//                intro2.setText(intro02);
//            }
//        }

        rb2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(TopMovieDetail.this, "你的评价为" + Float.toString(v) + "星", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}