package kaihatsu;


import java.util.Random;
import java.util.Scanner;
public class Ikuseigame {

	public static void main(String[] args) {
		//育成ゲーム
		//必要要素を用意
		int physical;//体力
		int stress;//ストレス
		int happiness;//幸福度
		int intelli;//賢さ
		String name;//名前
		int power=0;
		/*
"　　　 ／ ￣⌒￣ ＼_"
"　　／　　　　　 　 ヽ" 
"　/ 　⌒ 　　 　⌒　 ヽ"
"　l　　　  ▼　　　　　|" 
"　ヽ.　 　 人 　　　 ノ "
"　　 'ｰし――――Ｊ-ﾞﾞ"
		 */
		System.out.println("\r\n");
		System.out.println("　　　 ／￣⌒￣＼_");
		System.out.println("　　／　　　　　 　＼ " );
		System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
		System.out.println("　l　　　  ▼　　　　　|");
		System.out.println("　ヽ.　 　 人 　　　  ノ ");
		System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		consoleStop();
		System.out.println("カピバラの赤ちゃんが現れました");
		consoleStop();
		System.out.println("川が遠いので大人になるまで面倒を見ることにしました");
		consoleStop();
		//初期化
		physical=30;
		stress=30;
		happiness=30;
		intelli=20;
		//選択肢配列
		String[] checkbox={"【1】ごはんを与える","【2】寝かせる","【3】温泉に入れる","【4】勉強させる","【5】おみくじをひく"};
		//名前入力
		Scanner scan1 = new Scanner(System.in);
		System.out.println("名前を決めてください");
		name = scan1.nextLine();
        System.out.println(name+"と名づけられました");
        consoleStop();
        point(physical,stress,happiness,intelli,name);
        //start
        System.out.println("早速育てていきましょう");
        consoleStop();
        System.out.println("\r\n選択肢を選んでください");
        System.out.println("【1】ごはんを与える\r\n【2】寝かせる\r\n【3】温泉に入れる");
        Scanner scan2=new Scanner(System.in);
		int check = scan2.nextInt();
		if(check==1||check==2||check==3) {
			if(check==1) {
				System.out.println("…ご飯を食べています…");
				physical+=10;
				stress-=10;
				intelli+=0;
				happiness+=10;
				face(1);
			}else if(check==2) {
				System.out.println("…寝ています…");
				physical+=20;
				stress-=5;
				intelli+=10;
				happiness+=5;
				face(2);
			}else if(check==3) {
				System.out.println("…温泉に入っています…");
				physical+=15;
				stress-=15;
				intelli-=5;
				happiness+=15;
				face(3);
			}
		}else {
			System.out.println("（正しい数字が入力されませんでした）\r\n何もせず様子を見ることにしました");
			power++;
		}
		consoleStop();
		point(physical,stress,happiness,intelli,name);
		consoleStop();
		//2週目以降
		int num=0;
		while((num<5)||(physical<=0||stress>=100||happiness<=0)) {
			consoleStop();
			System.out.println("\r\n選択肢を選んでください");
			for(int i=0;i<checkbox.length;i++) {
				System.out.println(checkbox[i].replace("[","").replace("]","").replace(",",""));
			}
			
			Scanner scan3=new Scanner(System.in);
			int check2;
			check2= scan3.nextInt();
			if(check2==1||check2==2||check2==3||check2==4||check2==5) {
				if(check2==1) {
					System.out.println("…ごはんを食べています…");
					face(1);
					physical+=10;
					stress-=10;
					intelli+=0;
					happiness+=10;
				}else if(check2==2) {
					System.out.println("…ねています…");
					face(2);
					physical+=20;
					stress-=5;
					intelli+=10;
					happiness+=5;
				}else if(check2==3) {
					System.out.println("…温泉に入っています…");
					face(3);
					physical+=15;
					stress-=15;
					intelli-=5;
					happiness+=15;
				}else if(check2==4) {
					System.out.println("…勉強しています…");
					face(4);
					physical-=20;
					stress+=5;
					intelli+=20;
					happiness+=10;
				}else {
					System.out.println("…占い中です…");
					consoleStop();
					int ran = new Random().nextInt(100);//乱数
					int ans=show(ran);
					if(ans==1) {
						face(5);
						physical+=15;
						stress-=10;
						intelli-=5;
						happiness+=25;
					}else if(ans==2) {
						face(6);
						physical+=5;
						stress-=5;
						intelli+=0;
						happiness+=10;
					}else if(ans==3) {
						face(7);
						physical-=5;
						stress+=10;
						intelli+=15;
						happiness-=10;
					}else {
						face(6);
						physical-=20;
						stress+=25;
						intelli-=10;
						happiness-=25;
					}
				}
			}else {
				System.out.println("（正しい数字が入力されませんでした）\r\n何もせず様子を見ることにしました");
				power++;
			}
			consoleStop();
			point(physical,stress,happiness,intelli,name);
			num++;
			
		}
		//goal
		consoleStop();
		System.out.println("～～～～～～～～～～～～～～～～～～～");
		consoleStop();
		if(power==6) {
			System.out.println("かぴばらは一人でたくましく生きていきました");
			face(9);
			System.out.println("---END---");
		}
		else if(physical<=0||stress>=95||happiness<=0) {
			System.out.println("カピバラのライフは0です");
			endface(1);
			System.out.println("---BAD END---");
		}else if(intelli<=0) {
			System.out.println("野生で生きるための知能を失いました");
			endface(2);
			System.out.println("---BAD END---");
		}else if(intelli>=90) {
			System.out.println("インテリカピバラに成長しました\r\n一人でも賢く生き抜く力が備わりました");
			endface(3);
			System.out.println("---HAPPY END---");
		}else if(stress<10||happiness>=90) {
			System.out.println("ポジティブカピバラに成長しました\r\n何が起きてもポジティブに受け止める力が備わりました");
			endface(4);
			System.out.println("---HAPPY END---");
		}else if(physical>=90) {
			System.out.println("元気なカピバラに成長しました\r\nたくましく生き抜いていける力が備わりました");
			endface(5);
			System.out.println("---HAPPY END---");
		}else {
			System.out.println("なんとか成長しました");
			endface(6);
			System.out.println("---NORMAL END---");
		}
		
		
        
       
        
        scan1.close();
        scan2.close();
        
	}
	
	//ポイント表示
	public static void point(int physical,int stress,int happiness,int intelli,String name) {
		System.out.println("\r\n");
		System.out.println("　|"+name+"の状態");
		System.out.println("　|体力　　："+ physical);
		System.out.println("　|ストレス："+ stress);
		System.out.println("　|賢さ　　："+ intelli);
		System.out.println("　|幸福度　："+ happiness);

	}
	//おみくじ
	public static int show(int ran){
		int ans=0;
		//大吉
		if(ran%20==0) {
			System.out.println("【大吉】");
			ans=1;
		}
		//吉
		else if(ran%5==1||ran%5==2) {
			System.out.println("【吉】");
			ans=2;
		}
		//末吉
		else if(ran%5==3||ran%5==4) {
			System.out.println("【末吉】");
			ans=3;
		}
		//凶
		else if(ran%5==0) {
			System.out.println("【凶】");
			ans=4;
		}
		return ans;
	}
	//処理を止める
	static void consoleStop() {
		try {
			 Thread.sleep(2000); // 2秒(1000ミリ秒)間だけ処理を止める
			} catch (InterruptedException e) {
			}
	}
	//タイマー
	
	//カピバラの表情
	//【1】ごはん【2】寝る【3】温泉【4】勉強【5】大吉【6】吉【7】末吉【8】凶
	static void face(int face) {
		if(face==1) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ ﾓｸﾞﾓｸﾞ" );
			System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 ω　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==2) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ ..zzz" );
			System.out.println("　/ 　__　　 　__　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==3) {
			System.out.println("　　　  ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　 ＼ 　　 " );
			System.out.println(" 　/ 　⌒ 　　　⌒　  ヽ　　");
			System.out.println("|　l＃　　  ▼　　　＃ |　 |");
			System.out.println("|　ヽ.　 　 人 　　　  ノ  |");
			System.out.println("|　　 'ｰし――――Ｊ-ﾞﾞ　　|");
			System.out.println("|--------------------------|");
		}else if(face==4) {
			System.out.println("　　　 ／￣⌒￣＼　　　");
			System.out.println("　　／　̠̠　　̠̠　　＼ " );
			System.out.println("　/ 　 |__|==|__|　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　  　ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==5) {
			System.out.println("　♪　 ／￣⌒￣＼　　  ♪");
			System.out.println("♪　／　　　　　 　＼ ♪" );
			System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==6) {
			System.out.println("　　　 ／￣⌒￣＼　　　");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==7) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　　-`　 ´-　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(face==8){
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　　・　　　・　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　　-`　 ´-　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰ💪――――💪-ﾞﾞ");
		}
		
	}
	//エンド
	//【1】【2】BadEnd【3】【4】【5】HappyEnd【6】NormalEnd
	static void endface(int end) {
		if(end==1) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　 × 　　　×　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(end==2) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　 〇 　　　〇　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 △ 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(end==3) {
			System.out.println("　　　 ／￣⌒￣＼　　　");
			System.out.println("　　／　̠̠　　̠̠　　＼ " );
			System.out.println("　/ 　 |__|==|__|　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　  　ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(end==4) {
			System.out.println("　♪　 ／￣⌒￣＼　　  ♪");
			System.out.println("♪　／　　　　　 　＼ ♪" );
			System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 ω 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else if(end==5) {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　　-`　 ´-　　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 ω 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}else {
			System.out.println("　　　 ／￣⌒￣＼");
			System.out.println("　　／　　　　　 　＼ " );
			System.out.println("　/ 　⌒ 　　 　⌒　 ヽ");
			System.out.println("　l　　　  ▼　　　　　|");
			System.out.println("　ヽ.　 　 人 　　　  ノ ");
			System.out.println("　　 'ｰし――――Ｊ-ﾞﾞ");
		}
	}


}
