package com.example.final_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    int[] imageID=new int[]{R.mipmap.img1_12,R.mipmap.img1_22,R.mipmap.img1_32,R.mipmap.img1_42,R.mipmap.img1_52,R.mipmap.img1_62,R.mipmap.img1_72,R.mipmap.img1_82,R.mipmap.img1_92,R.mipmap.img1_102};
    ImageView img;
    RatingBar rb1;
    ImageButton btn1;
    String[] jjs=new String[]{"两个抗癌家庭，两组生活轨迹。影片讲述了一个温情的现实故事，思考和直面了每一个普通人都会面临的终极问题——想象死亡随时可能到来，我们唯一要做的就是爱和珍惜。",
            "究竟是什么塑造了真正的你？电影将聚焦乔伊·高纳（杰米·福克斯配音）。这位中学音乐老师获得了梦寐以求的机会——在纽约最好的爵士俱乐部演奏。但一个小失误把他从纽约的街道带到了一个奇幻的地方“生之来处”（the Great Before）。在那里，灵魂们获得培训，在前往地球之前将获得他们的个性特点和兴趣。决心要回到地球生活的乔伊认识了一个早熟的灵魂“二十二”（蒂娜·菲 配音），二十二一直找不到自己对于人类生活的兴趣。随着乔伊不断试图向二十二展示生命的精彩之处，他也将领悟一些人生终极问题的答案。",
            "对整洁和计划有着超乎常人执念的鲍抱（常远 饰），本以为自己是一个友情爱情的绝缘体，但在遇到个性率真宋温暖（李沁 饰）、妙手“神经”贾医生（沈腾 饰）和假仁假义王为仁（乔杉 饰）之后，上演了一段阴差阳错的喜剧故事…… 影片根据韩国电影《计划男》改编。",
            "香港某处发生爆炸案，前拆弹专家潘乘风（刘德华 饰）因昏迷于现场，被警方怀疑牵涉其中。苏醒后的潘乘风只能一边逃亡一边查明真相，然而，他的好友董卓文（刘青云 饰）和他的前女友庞玲（倪妮 饰）却给他讲述了两段截然不同的经历。有计划的爆炸案接二连三发生，真相却越来越扑朔迷离……",
            "在一次搓澡服务中，富二代肖翔（彭昱畅 饰）和搓澡工周东海（乔杉 饰）发生矛盾，让周东海面临生活困境。肖翔因跳伞事故被送到医院记忆全失，周东海恰巧撞见，心生一计，骗肖翔是自己的弟弟并骗回周家澡堂当搓澡工，于是一个富二代开始了一段终身难忘的搓澡生涯……",
            "海神的女儿波妞从深海出逃玩耍，却被困在玻璃瓶里冲到岸上，碰巧被住在岸边悬崖的宗介救出，两人因此相识。但是波妞的父亲——魔法师藤本，认为人类世界肮脏丑陋，强行把波妞带回海里。面对父亲的阻挠、席卷小镇的海啸，以及永远失去魔法的威胁，波妞仍然大胆而坚决地决定——要变成人类跟宗介在一起。而承诺要永远保护波妞的宗介，也即将面临新的挑战..",
            "上世纪90年代，刑警钟诚受命追捕悍匪集团“老鹰帮”。这群悍匪犯下惊天连环劫案，训练有素且纪律严明，首领张隼更屡次恶意挑衅，矛头直指钟诚。为将“老鹰帮”捉拿归案，钟诚带领刑警小队咬死不放，誓与恶势力斗争到底。数年间，警匪上演了一次次紧张刺激的较量，悍匪愈加猖獗，警方步步逼近，双方展开殊死对决……",
            "故事背景设定在五光十色、充满诱惑的80年代，神奇女侠戴安娜在华盛顿的自然历史博物馆过着与普通人无异的生活，然而在阻止了一场看似平常的劫案后，身边的一切都发生了变化。在强大的神力诱惑下，两位全新劲敌悄然出现——与神奇女侠“相爱相杀”的顶级掠食者豹女， 以及掌控着能改变世界力量的麦克斯·洛德，一场惊天大战在所难免。另外一边，旧爱史蒂夫突然“死而复生”，与戴安娜再续前缘，然而浪漫感动之余，史蒂夫的回归也疑窦丛生。 新时代大幕开启，面对两位强大的邪恶反派和神秘归来的史蒂夫，神奇女侠要如何才能再次拯救世界？",
            "倾覆沉没的钻井平台，顺流直冲的运油车头，直坠入海的满载客机。交通海上应急反应特勤队队长高谦（彭于晏 饰）、机长方宇凌（辛芷蕾 饰）和绞车手赵呈（王彦霖 饰）一次次带领队伍第一时间抵达，站在水火咆哮的最前面，守在危急撤离的最后面，用生命对抗天灾人祸。但在自然面前，特勤员毕竟没有超能力，血肉之躯踩在死亡边缘，真实的恐惧无数次让这些斗士颤抖、无助和气馁。而海上救援的字典里没有“退缩”。当你听见旋翼的轰鸣、洪亮的汽笛、马达的飞驰，那是他们无惧艰难险阻，舍己为人，谱写的一曲英雄之歌。",
            "是不是每个人的人生里都有一个爱不到的人？当毫无存在感的IT男费力（李鸿其 饰）遇见闪闪发光的女孩赵希曼（杨颖 饰），他找到了自己必须去冒险的理由。世间每一种限定浪漫，都是暗恋者的良苦用心。当明天到来，你还会记得最纯粹的感动和爱吗?如果有幸等到你，这个冬天一起去看极光吧⋯"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        img=(ImageView)findViewById(R.id.iv_img);
        rb1=(RatingBar)findViewById(R.id.rb1);
        btn1=(ImageButton)findViewById(R.id.btn1);
        img.setImageResource(imageID[bundle.getInt("position")]);
        TextView jianjie = (TextView) findViewById(R.id.tv_jianji);
        jianjie.setText(jjs[bundle.getInt("position")]);
        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(MovieDetail.this,"你的评价为"+Float.toString(v)+"星",Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}