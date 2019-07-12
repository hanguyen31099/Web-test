#include <iostream>
using namespace std;
char Matrix[5][5] ={ {0, 0, 0, 0},
					{1, 0, 0, 0},
					{0, 0, 0, 0},
					{0, 0, 1, 0}};
void display(int numberEnemy,int numberRockets,int countEnemyRound){
	printf("  ");
		for(int i=0;i<4;i++)printf("%d ",i);
		printf("\n");
		for(int i=0;i<4;i++){
			for(int j=-1;j<4;j++){
				if(j==-1)printf("%d ",i);
				else{
					if(Matrix[i][j]==2) printf("X ");
					else if(Matrix[i][j]==3) printf("O ");
					else printf("- ");
				}
			}
			printf("\n");
		}
		printf("%d enemy(s) around\n",countEnemyRound);
		printf("%d rockets left\n",numberRockets);
		printf("%d enemy(s) left\n",numberEnemy);
}
int main(){
	int numberEnemy = 2,numberRockets = 5;
	printf("  ");
	for(int i=0;i<4;i++){
		printf("%d ",i);
	}
	printf("\n");
	for(int i=0;i<4;i++){
		for(int j=0;j<5;j++){
			if(j==0){
				printf("%d ",i);
			}
			else{
				printf("- ");
			}
		}
		printf("\n");
	}
	
	while(true){
		int x,y,countEnemyRound = 0;
		printf("Your target? ");
		scanf("%d%d",&y,&x);
		if(Matrix[y][x]==0){
			Matrix[y][x] = 2;
			printf("You missed\n");
		}
		else if(Matrix[y][x] == 1){
			printf("You hit\n");
			Matrix[y][x] = 3;
			numberEnemy--;
		}
		for(int i=y-1;i<=y+1;i++){
			for(int j=x-1;j<=x+1;j++){
				if(i>= 0 && i <= 3
				&&j >= 0 && j <= 3 )
				{
					if(Matrix[i][j]==1){
						countEnemyRound++;
					}
				}
			}
		}
		numberRockets--;
		display(numberEnemy,numberRockets,countEnemyRound);
				if(numberEnemy == 0){
			printf("You won!");
			break;
		}
		else if(numberRockets == 0){
			printf("You lose!");
			break;
		}
		printf("\n");
	}
	return 0;
}
