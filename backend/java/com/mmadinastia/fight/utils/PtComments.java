package com.mmadinastia.fight.utils;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class PtComments {

	public static final ArrayList<String> apresentation = new ArrayList<String>(Arrays.asList(

			"Senhoras e senhores. Essa luta é de %d rounds, na divisão dos %s! %n"
					+ "Apresentando o lutador à minha esquerda, lutando no córner vermelho. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"
					+ "E apresentando o lutador à minha direita, lutando pelo córner azul. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n",

			"Senhoras e senhores. Essa luta é de %d rounds, pelo cinturão dos %s! %n"
					+ "Apresentando o campeão à minha esquerda, lutando no canto vermelho. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"
					+ "E apresentando o desafiante à minha direita, lutando no canto azul. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"));

	public static final ArrayList<String> punch1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta um gancho no corpo;e acerta as costelas de %d2 com força;mas %d2 consegue se esquivar;10;1;2;3;Gancho no corpo;1;1;-10;0;-5;1;1;",
			"%a1 finge um movimento e lança um belo uppercut;acertou o queixo de %d2;%d2 bloqueou. Foi fácil!;8;2;3;2;Uppercut;1;1;0;0;2;1;1;",
			"Combinação brilhante de %a1;que força %d2 a tentar se defender melhor.;%d2 está mostrando algumas habilidades de esquiva evitando aqueles socos.;7;2;1;3;Socos;4;3;2;2;1;1;1",
			"Grande bomba com a mão direita de %a1!;%d2 vai ter uma grande dor de cabeça depois desse golpe!;%d2 se abaixa...;4;1;2;4;Socos;1;1;1;1;1;1;1",
			"Grande bomba com a mão esquerda de %a1!;%d2 vai ter uma grande dor de cabeça depois desse golpe!;%d2 se abaixa...;5;1;2;4;Socos;1;1;1;1;1;1;1",
			"Bons Golpes de %a2!;Alguns socos fortes estão acertando!;%d2 bloqueia com confiança;8;3;1;2;Socos;3;3;2;2;3;1;1",
			"%a2 lança um gancho no corpo;Certeiro! %d2 sofre com ataque nas costelas!;%d1 se afasta procurando um contra-ataque...;10;4;1;2;Socos;1;1;0;2;0;1;1",
			"%a1 dá um soco;que encontra uma abertura na defesa de %d2.;que é desviado.;0;2;1;2;Socos;1;1;0;0;0;1;1",
			"Jabs sólidos de %a1.;Bons socos.;%d2 defende.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"Uma combinação sólida de %a1;conecta-se com %d2.;principalmente atinge o ar.;0;2;1;2;Socos;2;2;1;0;0;1;1",
			"%a1 está medindo %d2 com seu jab.;Boa precisão de sua parte.;%d2 não está preocupado.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"Golpe sólido de %a1 no corpo.;%d2 não gostou disso.;%d2 bloqueia no tempo certo.;9;2;1;4;Soco no corpo;1;1;-5;1;0;1;1",
			"Alguns contra-socos contra %d1;Acertam enquanto ele tenta se afastar.;Quase o acertam quando ele se afasta.;0;1;4;1;Socos;2;2;0;-1;0;1;1",
			"Bom movimento de %a2;Movendo-se para atacar e afastando-se depois.;que está balançando e ziguezagueando.;0;0;1;3;Socos;2;2;1;0;0;1;1",
			"%a1 dispara um soco pouco ortodoxo no torso de %d2;que atinge o alvo.;que vai longe.;11;2;1;2;Soco no corpo;1;1;-5;-1;-3;1;1",
			"Um soco de %a1;arranhou a bochecha esquerda de %d2.;passou zunindo por %d2.;4;2;1;4;Socos;1;1;0;-1;0;1;1",
			"Um soco de %a1;arranhou a bochecha direita de %d2.;foi bloqueado por %d2.;5;2;1;4;Socos;1;1;0;-1;0;1;1",
			"%a1 golpeia %d2;acertando seu peito.;sem efeito visível.;9;2;1;2;Jab;1;1;-5;-1;-2;1;1",
			"%a2 lança uma rajada de socos;mas só consegue acertar golpes de raspão.;%d2 escapa do perigo.;0;3;1;3;Socos;3;2;0;-1;0;1;1"));

	public static final ArrayList<String> punch2 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta um gancho no corpo;e acerta as costelas de %d2 com força;mas %d2 consegue se esquivar;10;1;2;3;Gancho no corpo;1;1;-10;0;-5;1;1;",
			"%a1 finge um movimento e lança um belo uppercut;acerta no queixo de %d2;%d2 bloqueia. Ele fez parecer fácil!;8;2;3;2;Uppercut;1;1;0;0;2;1;1;",
			"Combinação brilhante de %a1;que força %d2 a tentar se defender melhor.;%d2 está mostrando algumas habilidades de esquiva evitando esses socos.;7;2;1;3;Socos;4;3;2;2;1;1;1",
			"Grande golpe de direita de %a1!;%d2 vai ter uma grande dor de cabeça depois desse golpe!;%d2 se abaixa...;4;1;2;4;Socos;1;1;1;1;1;1;1",
			"Grande golpe de esquerda de %a1!;%d2 vai ter uma grande dor de cabeça depois desse golpe!;%d2 se abaixa...;5;1;2;4;Socos;1;1;1;1;1;1;1",
			"Golpes duros de %a2!;Alguns socos fortes estão entrando!;%d2 bloqueia com confiança;8;3;1;2;Socos;3;3;2;2;3;1;1",
			"%a2 lança um gancho no corpo;Acertou em cheio, %d2 sobre um belo golpe nas costelas!;%d1 se afasta procurando um contra-ataque...;10;4;1;2;Socos;1;1;0;2;0;1;1",
			"%a1 golpeia...;forte impacto no rosto de %d2!;...passa no vazio.;0;2;2;4;Socos;1;1;1;1;1;1;1",
			"Gancho rápido de %a1;Bom soco! %d2 tem motivos para se preocupar.;olha para os braços de %d2.;0;2;1;4;Gancho;1;1;1;1;1;1;1",
			"Uma mão direita de %a1;surpreende %d2!;erra o alvo.;0;2;1;2;Socos;1;1;1;0;2;1;1",
			"Uma mão direita de %a1;faz %d2 tropeçar para trás!;é desviado.;0;2;1;3;Socos;1;1;0;1;2;1;1",
			"%a1 lança um uppercut;que acerta com firmeza.;%d2 desvia.;0;2;3;4;Uppercut;1;1;0;0;1;1;1",
			"%a2 lança um gancho;que acerta o alvo.;Ele não acerta.;0;2;1;2;Gancho;1;1;1;1;1;1;1",
			"Vários bons golpes no corpo;acertam em %d2.;são evitados por %d2.;9;3;3;4;Socos no corpo;4;4;-5;3;1;1;1",
			"Um gancho de esquerda de %a2;arranhou o queixo de %d2.;errou...;8;2;1;2;Gancho;1;1;0;0;1;1;1",
			"%a1 atacando em volume, soltando bastante socos.;%d2 pode estar em apuros!;%d2 defende rapidamente.;0;2;1;3;Socos;4;3;1;1;2;1;1",
			"%a2 evita um golpe perigoso de %d2;e contra-ataca com um direto sólido!;E se defende com socos pra manter a distância.;0;1;1;2;Socos;1;1;1;1;1;1;1",
			"%a1 tenta encurralar %d2 com socos;%d2 desvia dos golpes.;%d2 evita ser encurralado.;0;2;3;1;Socos;5;4;1;1;2;1;1",
			"Alguns bons socos de %a1;Que atordoam %d2.;Erram o alvo.;0;2;1;2;Socos;3;3;1;0;2;1;1",
			"%d2 ataca com um soco;%a1 evita e acerta com um uppercut de contra-ataque!;%a1 foge, mas desvia com um contra-ataque.;0;2;3;2;Uppercut;1;1;0;0;2;1;1",
			"%d2 lança um chute;mas %a1 evita e acerta um gancho no contra-ataque!;%a2 desvia e mantém a distância.;0;0;1;2;Gancho;1;1;0;0;2;1;1",
			"%d1 avança em %a2.;%a2 responde com socos sólidos!;%a2 balança ineficazmente.;0;2;1;3;Socos;5;4;1;1;2;1;1",
			"%d2 avança;%a1 o acerta com um uppercut no rosto!;%a2 finta.;0;2;3;1;Uppercut;1;1;0;0;2;1;1",
			"Belo soco de %a1;que se dá melhor que seu oponente nesta troca.;que quase acerta %d2.;0;1;2;4;Socos;1;1;1;1;1;1;1",
			"%a1 tenta uma bela combinação dupla;Ele acerta!;que é bloqueada.;0;1;1;3;Socos;2;2;1;0;2;1;1",
			"Uppercut preciso de %a2 seguido de um jab forte;%d1 tropeça para trás.;%d2 desvia os golpes.;0;2;2;3;Socos;2;2;1;0;1;1;1",
			"%d1 lança um soco na linha de cintura;%a2 desvia e o acerta com um cruzado forte.;%a2 foge.;0;1;1;2;Socos;1;1;1;1;1;1;1",
			"Cruzado diagonal de %a1;acerta %d2.;não leva a lugar nenhum.;0;2;2;4;Cruzado diagonal;1;1;1;1;1;1;1",
			"%a2 foca no corpo...;Ele pune as costelas de %d2 com alguns ganchos.;seus socos arranham o braço de %d2.;10;2;2;3;Socos no corpo;2;2;-5;2;0;1;1",
			"Belos socos de %a1.;%d2 cambaleia para trás. %a2 quer terminar isso e continua lançando bombas!;Bloqueios ainda melhores de %d2.;0;3;1;4;Socos;6;5;2;2;3;1;1",
			"%a2 mostrando um timing excelente, acerta %d1 com a mão direita.;Grande gancho de %a1! %d1 é pego desequilibrado e cai no chão!;%d2 dá um passo para trás e o soco vai longe.;0;1;1;2;Socos;1;1;0;0;2;2;0;",
			"%a2 está pressionando contra as grades!;Um golpe que quase quebra a mandíbula de %d2!;%d2 recua e cria espaço. %a1 está perguntando se ele vai lutar!;5;0;1;4;Socos;1;1;0;1;2;0;0;"

	));

	public static final ArrayList<String> punch3 = new ArrayList<String>(Arrays.asList(
			"%a2 começa a lançar uma chuva de socos sobre %d2;isso está ficando cada vez pior para %d2;%d1 é esperto o suficiente para se esquivar para trás;7;2;1;2;Socos;6;4;0;0;2;1;1;",
			"Magnífico haymaker de %a2;que cai no rosto de %d2 como uma bala de canhão!;%d2 consegue se mover para o lado;7;1;3;1;Haymaker;1;1;0;0;3;1;1;",
			"%a1 tenta mostrar suas habilidades de boxe com um combo um-dois;e esses socos estão acertando o rosto de %d2;%d1's sabe o que fazer aqui e os bloqueia;7;0;1;3;Socos;2;2;1;0;2;1;1",
			"%a2 finta e avança para acertar com um gancho;que soco certeiro!;%d2 desvia e sai.;8;2;1;4;Uppercut;1;1;2;2;3;1;1",
			"%a1 persegue %d2 e desfere alguns golpes perfeitos;Aqui vamos nós! %d2 dá um passo para trás quando esses socos atingem seu rosto;%d2 se abaixa para trás e os evita.;5;3;1;2;Socos;4;3;1;2;2;1;1",
			"Um overhand de direita de %a1 que parecia ser capaz de destruir uma parede de tijolos!;Bomba! %d2's para esse soco com a cara! ;6;1;1;3;Socos;1;1;3;3;1;1;1",
			"Combinação brutal de %a1!;%d2 está em péssimo estado, suas pernas parecem bambas!;%d2 se move para o lado e se esquiva.;8;3;2;4;Socos;4;4;2;2;4;1;1",
			"A mente de %a1 está definitivamente na luta, %d2 acabou de ser acertado! %a1 viu uma abertura e desferiu uma grande direita;Uau! %d2 vai ter dor de cabeça depois dessa.;%d2 se move para o lado e se esquiva. ;8;2;1;2;Socos;1;1;1;1;3;1;1",
			"%a1 encontrou uma brecha na defesa de %d2, lançando um grande gancho;Bomba! Isso pode quebrar as costelas de %d2.;%d1 dá um passo para trás e evita aquele gancho!;10;2;2;1;Gancho;1;1;-5;0;-2;1;1",
			"%a1 encontrou uma abertura na defesa de %d2, lançando um grande uppercut;Bingo! %d2 está balançando!;%d1 é rápido o suficiente para desviar desse uppercut.;8;2;1;3;Uppercut;1;1;1;0;2;1;1",
			"%a1 lança um overhand com a mão esquerda...;Isso cai no queixo de %d2! Isso para %d2 em seu caminho!;%d2 se move para o lado e se esquiva.;3;0;3;4;Socos;1;1;1;1;0;1;1",
			"%a1 lança um overhand com a mão direita...;Isso cai no queixo de %d2! Isso para %d2 na sua movimentação!;%d2 se move para o lado e se esquiva.;2;0;3;4;Socos;1;1;1;1;0;1;1",
			"%d2 segue %a1;apenas para levar um grande contra-ataque! %d2 precisa parar de jogar o jogo de %a1 ou será nocauteado!;%a2 finge um movimento.;0;1;1;2;Socos;1;1;1;0;2;1;1",
			"%a1 está abrindo em %d2 e chovendo combinações!;O corner de %d2 parece preocupado!;%d2 não parece preocupado enquanto defende.;0;2;1;4;Socos;3;3;1;1;3;1;1",
			"Uma bomba vista em toda a arena!;%d2 tropeça para trás, seu corner está gritando! %a1 está vindo de novo!;Defesa oportuna por %d2.;0;2;1;2;Socos;1;1;1;0;3;1;1",
			"Soco surpresa de %a2.;Parece que %d2 foi atingido por um ônibus!;Os reflexos de%d1 o salvaram!;0;1;1;3;Socos;1;1;0;0;3;1;1",
			"Uma rajada furiosa de socos de %a1;coloca %d2 em um mundo de dor!;apenas erra %d2.;0;1;1;4;Socos;7;6;1;0;3;1;1",
			"%a1 ataca %d2 lançando rajadas de socos para a esquerda e para a direita.;Não há muitos socos acertando, mas os que acertam são enormes! %d2 é balançado!;%d1 sai do caminho.;0;1;2;4;Socos;4;2;0;0;3;1;1",
			"%d1 lança um combo;%a1 se abaixa e o pega com um contra-ataque direto! %d2 balança novamente, apenas para ser contra-atacado mais uma vez! %d2 está parecendo mal aqui!;%a2 soca de volta, mas ninguém acerta.;0;1;1;3;Socos;4;4;1;0;4;1;1",
			"Um soco perverso de %a1;acerta %d2!;dá errado.;0;2;1;2;Socos;1;1;1;1;3;1;1",
			"Pulverizando socos na cabeça de %d2!;Ai, isso tinha que doer!;%d2 escapa do soco.;0;2;1;3;Socos;1;1;1;0;2;1;1",
			"%a2 lança um combo duplo e depois finge um movimento para disparar uma grande mão direita no queixo!;Os golpes acertam o alvo!;a defesa de%d2 amortece os golpes.;8;1;3;4;Socos;3;3;1;0;3;1;1",
			"%a2 desvia de um golpe e contra-ataca com um gancho esmagador;que quase levanta %d2 do chão!;que erra por um centímetro!;0;1;2;4;Gancho;1;1;2;1;3;1;1",
			"%a1 lança uma série rápida de socos;levando %d2 de uma ponta a outra do octógono. Isso é incrível!;aquela olhada nos braços de %d2.;0;1;1;2;Socos;10;9;2;2;3;1;1",
			"%d2 dá um chute preguiçoso;%a2 desvia e dispara um uppercut que quase o coloca em órbita!;%a2 bloqueia e mantém distância.;0;0;2;4;Uppercut;1;1;2;2;4;1;1",
			"Incrível haymaker de %a1!;Você pode ver a cabeça de %d1 sendo jogada para trás!;Erra por uma milha.;0;4;1;2;Socos;1;1;2;1;3;1;1",
			"%a2 lança um gancho furioso!;Isso atinge o queixo de %d2 como uma bola de demolição! %d2 perde o equilíbrio e vai para o chão.;%d2 se abaixa e empurra %a1 criando algum espaço.;8;-1;1;4;Socos;1;1;0;2;4;2;0;",
			"%a1 lança alguns golpes e depois um grande gancho!;%d2 bloqueia os golpes, mas o último soco atinge com força a bochecha de %d1! %d2 tropeça e cai no chão!;%d2 bloqueia e tenta dar a volta seu oponente procurando ângulos.;4;0;1;2;Socos;1;1;0;2;3;2;0;",
			"%a1 lança alguns golpes e depois um grande gancho!;%d2 bloqueia os golpes, mas o último soco atinge com força a bochecha de %d1! %d2 tropeça e cai no chão!;%d2 bloqueia e tenta dar a volta seu oponente procurando por ângulos.;5;0;1;2;Socos;3;1;0;2;3;2;0;"));

	public static final ArrayList<String> kicks1 = new ArrayList<String>(Arrays.asList(
			"Chute baixo de %a1 para manter a distância.;Acertou o tornozelo de %d1;Passou no vazio. Isso estava longe de acertar.;17;3;1;2;Chutes;1;1;-5;-5;0;1;1",
			"Chute baixo de %a1 para manter a distância.;Acertou o tornozelo de %d1;Passou no vazio. Isso estava longe de acertar.;18;3;1;2;Chutes;1;1;-5;-5;0;1;1",
			"%a1 avança e desfere um chute baixo.;Golpe forte na coxa esquerda de %d2;%d2 bloqueia.;15;2;1;3;Chutes;1;1;-5;-5;0;1;1",
			"%a1 avança e desfere um chute baixo.;Golpe forte na coxa direita de %d2;%d2 bloqueia.;16;2;1;3;Chutes;1;1;-5;-5;0;1;1",
			"%a2 não está mostrando uma grande técnica com aquele chute baixo...;Acerta bem a coxa de %d2;%d2 é esperto o suficiente para bloquear.;16;3;3;1;Chutes;1;1;-5;-5;0;1;1",
			"Chute na linha de cintura de %a1...;apenas roça no oponente.;é bloqueado.;11;2;1;2;Chute corporal;1;1;-5;-5;0;1;1",
			"Um Chute de %a1;arranhou a cabeça de %d2, mas ele parece bem.;não atingiu o alvo.;0;3;1;4;Chute;1;1;-2;-2;0;1;1",
			"Um Chute de %a1;olha para %d2.;erra feio. %a2 escorrega e cai!;9;0;0;0;Chute;1;1;-1;-2;-2;1;3",
			"Um monte de chutes na perna de %a1;estão incomodando seu oponente.;são bloqueados por %d2.;15;2;1;2;chutes baixos;3;3;-5;-3;0;1;1",
			"%a2 dá um chute no corpo.;Chute certeiro!;Bloqueado por %d2.;11;2;1;2;Chute no corpo;1;1;-5;-2;0;1;1",
			"Bom chute na perna de %a1.;%d2 estremece um pouco.;%d1 defende com facilidade.;16;2;1;2;Chutes baixos;3;3;-5;-3;0;1;1",
			"Toda vez que %d1 tenta entrar na distancia;%a2 dá um chute baixo, controla bem a distancia;%a2 erra um chute baixo, precisa caprichar;17;3;1;2;chutes baixos;2;2;-5;-7;0;1;1",
			"Belo chute baixo de %a2;Barulho de impacto alto!;mas %d1 interrompe.;15;3;1;2;Chutes;1;1;-5;-5;0;1;1"));

	public static final ArrayList<String> kicks2 = new ArrayList<String>(Arrays.asList(
			"%a2 lança um forte chute baixo!;%d2 recebe um duro golpe na perna esquerda!;%d2 bloqueia.;17;1;1;3;Chutes;1;1;-3;0;0;1;1",
			"%a2 lança um forte chute baixo!;%d2 recebe um forte golpe na perna direita!;%d1 bloqueia;18;1;1;3;Chutes;1;1;-3;0;0;1;1",
			"Bom chute frontal de %a2!;%d2 tropeça para trás depois desse!;%d1 bloqueia;11;0;1;4;Chute frontal;1;1;0;0;0;1;1",
			"Chute baixo ultrarrápido de %a2!;Fez um barulho alto, tenho certeza que dói!;%d2 bloqueia aquele chute com a perna.;16;0;1;3;Chutes;1;1;0;0;0;1;1",
			"%a1 finge um movimento e lança um chute no fígado!;Isso machuca %d1! Tenho certeza que seu fígado vai doer amanhã.;%d2 bloqueia e empurra seu oponente.;10;0;1;4;Meio chute;1;1;0;1;0;1;1",
			"Chute baixo sólido de %a1.;Com certeza, isso deve doer!;%d2 desvia.;15;1;1;2;Chutes;1;1;-3;-3;0;1;1",
			"Chute por dentro de %a2.;%d2 recebe um chute sólido na coxa.;O chute passa no vazio.;10;2;1;2;Chute corporal;1;1;-3;-3;0;1;1",
			"Chute sólido na perna de %a1;que dói visivelmente %d2.;%d2 se defende.;17;1;1;2;Chutes;1;1;-3;-1;0;1;1",
			"%a2 dá um chute baixo;Ele muda de alvo e acerta um chute na linha de cintura excelente!;%d1 bloqueia.;11;1;2;1;Chute corporal;1;1;-3;-1;0;1;1",
			"%a2 dispara chutes baixos;punindo as pernas de %d2 repetidamente.;que não acertam.;15;2;1;2;chutes baixos;3;3;-3;-1;0;1;1",
			"Tentativa de chute interno por %a2;que acerta a perna de %d1.;que dá errado.;16;2;1;4;Chutes;1;1;-3;-2;0;1;1",
			"%a1 lança um chute baixo;que quase torce o joelho de %d2!;que é bloqueado rapidamente.;18;2;1;2;Chutes;1;1;-3;0;0;1;1",
			"%a1 tenta um Chute;%d2 bloqueia com o braço! Uau, isso foi alto!;%d1 bloqueia e se afasta.;14;2;2;4;chute central;1;1;-3;-1 ;0;1;1",
			"%a2 move-se para o lado e desfere um furioso chute baixo!;Golpe forte na coxa de %d2!;%d1 detém o chute.;16;0;1;2;Chutes;1;1;0;1;-1;0;0;"));

	public static final ArrayList<String> kicks3 = new ArrayList<String>(Arrays.asList(
			"%a1 avança e lança um Chute!;Chute cruel!;%d2 se abaixa.;4;-2;1;3;Chute;1;1;3;3;5;1;1",
			"%a1 tenta um Chute!;%d2 estava defendendo um chute na linha de cinturão, mas esse quase arrancou sua cabeça!;%d2 bloqueia. Uau, isso poderia ter terminado esta luta.;4;0;1;2;Chute;1;1;2;2;7;1;1",
			"Lá vem %a1 com um cruel chute do meio!;Acerta forte nas costelas de %d2!;%d1 desvia daquele que se move para trás;10;0;1;4;Chute do meio;1;1;0;3;0;1;1",
			"%a1 dá um passo à frente e dispara um Chute!;Chute cruel, não acredito que acertou!;%d2 bloqueia decisivamente, como se dissesse: Aqui não!;0;-1;1;4;Chute;1;1;3;2;5;1;1",
			"Um movimento ruim de %d1;permite que %a2 acerte um chute forte na cabeça.;quase coloca sua cabeça no caminho do chute de %a2.;0;1;3;4;Chute;1;1;1;0;3;1;1",
			"%d2 se move para atacar;mas %a1 acerta uma joelhada que o destrói!;%a2 erra uma joelhada.;0;1;4;3;Joelhada;1;1;3;2;7;1;1",
			"Chute de aparência brutal de %a1!;Você pode ouvir o impacto em toda a arena!;%d2 esquiva!;0;-1;2;1;Chute;1;1;2;1;6;1;1",
			"%d2 tenta um soco;%a1 pula para trás e desfere um poderoso chute na cabeça!;mas para antes de tentar o chute em %a2.;0;1;4;2;Chute;1;1;2;2;5;1;1",
			"%a1 quer esta vitória. Ele desfere um chute.;Chute brutal para %d2!;Seu oponente está em outro lugar, procurando contra-atacar...;0;3;2;4;Chute;1;1;3;2;5;1;1",
			"Chute de %a1!;%d2 parece ter sentido!;Ele erra por pouco!;0;-2;1;3;Chute;1;1;2;1;7;1;1",
			"%a2 lança um chute medio sólido;que acerta %d2!;que passa zunindo por %d2.;11;0;2;4;Chute;1;1;-7;2;0;1;1",
			"%a2 vai para um chute baixo..;Mais rápido que um piscar de olhos, ele segue com um Chute!;%d2 evita o golpe mortal.;0;-1;2;4;Chute;2;2;3;3;5;1;1",
			"Chute incrível!;%d2 está preocupado!;%d2 desvia e sai.;9;0;1;2;Chute;1;1;3;3;4;1;1"));

	public static final ArrayList<String> fancyKick1 = new ArrayList<String>(Arrays.asList(
			"%a1 pula no ar e tenta uma joelhada voadora!;Voadora esmagadora! O protetor bocal de %d2 voa para fora"
					+ " de sua boca;%d2 bloqueia com os braços e se move lateralmente em busca de um contra-ataque;7;2;0;8;Joelhada "
					+ "voadora ;1;1;0;2;3;0;0;",
			"%a2 gira e tenta um chute giratório para trás!;%d1 não esperava algo assim! Acertou seu queixo! Acabou?;%d2 se "
					+ "abaixa e hesita por um momento...;8;2;0;3;Chute giratório;1;1;0;2;3;0;0;",
			"%a2 gira e tenta um chute giratório na linha de cintura!;%a1 acerta %d2 nas costelas com força! %d2 parece claramente "
					+ "sentiu.;%d2 bloqueia com os braços e a perna;10;2;1;2;Chute giratório;1;1;0;2;3;0;0;"

	));

	public static final ArrayList<String> dirtyClinch = new ArrayList<String>(Arrays.asList(
			"%a2 quer encurtar a distância e tenta agarrar...;Bom movimento. Ele vai pra cima do oponente e segura o pesçoco com uma "
					+ "mão.;%d2 não quer nada disso enquanto se move para trás;0;0;0;0;Boxe Sujo;0;0;0;0;0;12;0;",
			"%a1 tenta levar a ação para seu campo favorito enquanto tenta agarrar;Grande movimento de %a1 que empurra seu oponente "
					+ "para frente com um overhook no clinche.;%d1 balança e %a2 tem que recuar;0;0;0;0;Boxe Sujo;0;0;0;0;0;12;0;",
			"%a2 avança procurando por alguma ação;Ele surpreende %d2 com um overhook !;%d1 não quer engajar e recua;0;0;0;0;Boxe Sujo;0;0;0;0;0;0;0;"));

	public static final ArrayList<String> thaiClinch = new ArrayList<String>(Arrays.asList(
			"%a1 se move para frente procurando por alguma oportunidade de agarrar;%a2 antecipa ao seu oponente com facilidade e entra "
					+ "no clinche !;%d2 empurra seu oponente e mantém a distância;0;0;0;0;Thai Clinche;0;0;0;0;0;12;0;",
			"%a1 finge um soco e se joga sobre %d1;Grande movimento de %a2 que empurra seu oponente para baixo de um problemático clinche"
					+ " tailandês;%d2 contra-ataca com alguns socos e depois recua;0;0;0;0;Thai Clinche ;0;0;0;0;0;12;0;",
			"%a2 pula vai pra cima de seu oponente e tenta agarrá-lo;%a1 empurra seu oponente contra a grade e domina seu pescoço;%d2 vê "
					+ "o que está por vir e se abaixa sob seu oponente e se move para o lado;0;0;0;0;Thai Clinche;0;0;0;0;0;12;0;"));

	public static final ArrayList<String> thaiPunch1 = new ArrayList<String>(Arrays.asList(
			"%a1 dá uma rajada de socos enquanto está no clinche!;%d2 está sendo atingido com força aqui!;%d1 empurra %a2 e quebra o"
					+ " clinche.;7;3;1;2;Socos;4;4;0;-2;-2;12;1",
			"%a2 tenta um boxe sujo enquanto segura %d2 contra %site;%d2 não consegue se defender e recebe alguns socos nas costelas.;%d2 "
					+ "percebe o que está ao seu redor e foge do clinch.;10;2;1;4;Socos;3;3;0;0;0;12;1",
			"%a1 está lutando e lançando alguns socos selvagens...;Não sei como %d2 está aguentando esses socos!;Não é o melhor movimento "
					+ "contra %d1 que tenta se aproveitar dos erros de seu oponente.;4;4;3;7;Socos;3;2;0;0;1;12;12",
			"Uma aula de boxe sujo de %a2 que está tentando punir as costelas de %d1 com alguns socos.;Ele acerta alguns golpes antes que a"
					+ " dor faça %d2 reagir e defender seu lado.;%d2 aproxima seu oponente e bloqueia %a2 socos.;10;0;4;3;socos;4;2;0;0;0;0;0;",
			"%a1 tenta golpear %d2 com o cotovelo no clinche;bem feito %d2 foi atingido!!! de novo e de novo, ele tem que se defender antes "
					+ "que o juiz pare essa luta;%d2 viu isso chegando e bloqueou com facilidade ;1;2;1;4;Cotovelos;3;3;3;1;2;0;0;",
			"ambos os lutadores estão clinchando, %a1 reage primeiro tentando acertar %d2 com um golpe de cotovelo direito;Grande cotovelada"
					+ " !!! esse cotovelo derruba %d2 no chão;%d2 bloqueia aquele cotovelo e os dois homens continuam a disputar;4;2;1;4;Cotovelo;1;1;3;1;2;2;0;",
			"ambos os lutadores estão clinchando, %a1 reage primeiro tentando acertar %d2 com um golpe de cotovelo esquerdo;Grande cotovelada"
					+ " !!! esse cotovelo derruba %d2 no chão;%d2 bloqueia aquele cotovelo e ambos continuam a se agarrar;5;2;1;4;Cotovelo;1;1;3;1;2;2;0;",
			"%a1 estava segurando %d1 contra %holdSite, ele balança o braço direito sobre a cabeça de %d2 e tenta acertá-lo com uma cotovelo "
					+ "reverso ;%d1 está sendo punido aqui, ele foi atingido novamente e novamente a luta não vai durar muito se isso continuar;%d2 bloqueia aquele cotovelo e sai do perigo;4;2;1;4;Cotovelos;3;3;1;3;2;0;0;",
			"%a1 estava segurando %d1 contra %holdSite, ele balança o braço esquerdo sobre a cabeça de %d2 e tenta acertá-lo com o cotovelo "
					+ "reverso ;%d1 está sendo punido aqui, ele foi atingido de novo e de novo a luta não vai durar muito se isso continuar;%d2 bloqueia aquele cotovelo e sai do perigo;5;2;1;4;Cotovelos;3;3;1;3;2;0;0;",
			"%a1 empurra %d1 contra %holdSite e tenta acertá-lo com a parte de trás do cotovelo;5;2;1;4;Cotovelos;3;3;1;3;2;2;0;",
			"%a1 empurra %d1 contra %holdSite e tenta acertá-lo com a parte de trás do cotovelo;4;2;1;4;Cotovelos;3;3;1;3;2;2;0;",
			"%a1 agarra %d1 e tenta acertá-lo com o cotovelo;cotovelo esquerdo, cotovelo direito e cotovelo esquerdo novamente!!! bela "
					+ "combinação de %a2, %d2 com certeza se machucou ali;%d1 não quer nada com ele e empurra %a2 para longe;1;2;1;4;Cotovelos;3;3;3;1;2;0;0;",
			"%a1 agarra %d1 e tenta acertá-lo com o cotovelo;cotovelo direito, cotovelo esquerdo e cotovelo direito novamente!!! bela"
					+ " combinação de %a2, %d2 com certeza se machucou ali;%d1 não quer nada com ele e empurra %a2 para longe;1;2;1;4;Cotovelos;3;3;3;1;2;0;0;",
			"%a1 está agarrando com as costas de %d1 contra %holdSite, %a2 tenta uma grande cotovelada;bang!!! que impacto!!! %d1 cai no"
					+ " tatame;%d1 bloqueia aquele e força %a1 a sair com algo melhor;1;2;1;4;Cotovelo;1;1;3;1;2;2;0;"

	));

	public static final ArrayList<String> thaiPunch2 = new ArrayList<String>(Arrays.asList(
			"A grade está se tornando o pior inimigo de %d1 ! %a2 está dando uma rajada de socos!;%d1 simplesmente não consegue escapar!;%d2 "
					+ "se abaixa e sai do canto.;5;0;2;1;Socos;5;3;2;0;1;12;1",
			"%a2 está lançando alguns grandes socos nas costelas de %d2 durante o clinche.;Uau. Você pode ver a dor nos olhos de %d1.;%d2 faz"
					+ " os bloqueios.;10;0;3;4;Socos;3;3 ;0;2;0;12;12",
			"%a2 empurra %d1 e começa a lançar uma rajada de ganchos e socos no corpo!;%d2 tropeça para trás, mas %a1 o persegue e continua a "
					+ "chuva de golpes!;%d2 segura seu oponente com força enquanto tenta esfriar o ação.;3;0;3;9;Socos;6;4;0;1;1;12;12",
			"%a1 se posiciona e lança outra série de socos!;Muitos deles estão acertando %d2 com força, que pode estar se perguntando como "
					+ "escapar disso!;%d2 empurra seu oponente para frente e bloqueia a maior parte da ofensiva de %a1.;9;0;1;3;Socos;5;3;0;0;0;0;0;"

	));

	public static final ArrayList<String> thaiPunch3 = new ArrayList<String>(Arrays.asList(
			"Socos brutais no rosto de %d2 durante o clinch!;%d2 não pode dar sofrer mais golpes como esses!;%d2 empurra %a1 "
					+ "com toda a sua força enquanto tenta manter a luta a distância.;4;-2 ;1;2;Socos;5;4;3;3;3;12;1",
			"%a2 empurra %d1 novamente no %HoldSite e começa uma combinação implacável de socos. A multidão está de pé!;%d2 "
					+ "não consegue escapar do clinch de %a1! %a1 está apenas brutalizando %d2 com socos uma e outra vez!;%d2 tenta bloquear"
					+ " %a1 socos...;6;0;3;7;Socos;4;4;2;3;4;12;12",
			"%a1 é absolutamente aterrorizante com seu poder no clinch e está punindo violentamente %d2 com uppercuts!;%d2 "
					+ "está levando mais do que pode suportar. Isso pode acabar em breve se %d2 não conseguir escapar!;Nada que %d2 deve temer"
					+ " enquanto ele bloqueia bem;3;0;3;1;Socos;3;3;2;2;4;12;12",
			"%a2 empurra %d1 contra %holdSite e desfere alguns socos doentios;Alguns uppercuts não respondidos colidem com o"
					+ " queixo de %d2! Suas pernas estão balançando!;%d2 bloqueia e empurra seu oponente para longe criando espaço entre eles.;8;"
					+ "0;2;4;Uppercuts;3;2;0;0;2;0;1;",
			"Uppercut doentio de %a1!;Aquele quase quebrou o queixo de %d2! Ele foi derrubado!;%d1 é ágil o suficiente para"
					+ " evitar aquele! Sorte sua %d2! Teria terminado esta luta.;8;2;1;9;Uppercut;1;1;1;2;3;2;0;"

	));

	public static final ArrayList<String> dirtyBoxing1 = new ArrayList<String>(Arrays.asList(
			"%a1 dá uma rajada de socos enquanto está no clinche!;%d2 está sendo atingido com força aqui!;%d1 empurra %a2 e quebra o "
					+ "clinche.;7;3;1;2;Socos;4;4;0;-2;-2;12;1",
			"%a2 tenta boxe sujo enquanto segura %d2 contra %site;%d2 não consegue se defender e recebe alguns socos nas costelas.;%d2 "
					+ "percebe o que está ao seu redor e foge do clinch.;10;2;1;4;Socos;3;3;0;0;0;12;1",
			"%a1 está lutando e lançando alguns socos selvagens...;Não sei como %d2 está aguentando esses socos!;Não é o melhor movimento"
					+ " contra %d1 que tenta se aproveitar dos erros de seu oponente.;4;4;3;7;Socos;3;2;0;0;1;12;12",
			"Uma aula de boxe sujo de %a2 que está tentando punir as costelas de %d1 com alguns socos.;Ele acerta alguns golpes antes que a"
					+ " dor faça %d2 reagir e defender seu lado.;%d2 aproxima seu oponente e bloqueia os socos de %a2 .;10;0;4;3;socos;4;2;0;0;0;0;0;",
			"%a1 tenta controlar %d1 no clinch e usar seu boxe sujo;%a2 empurra a nuca de %d1 com uma mão e dá alguns socos na cabeça dele"
					+ " com a outra, isso com certeza o machuca;%d2 empurra %a2 longe antes que ele pudesse tentar qualquer coisa;0;2;1;4;Socos;3;3;0;0;0;0;1;",
			"%a1 empurra %d2 contra %site e tenta trabalhar seu boxe sujo;%a2 controla %d1 no clinch e desfere alguns uppercuts, belos golpes"
					+ " %d2 é ferido;%d2 empurra %a2 para longe e gira;8 ;2;1;4;Uppercuts;3;3;0;0;0;0;1;",
			"%a1 tenta segurar %d1 em um clinch contra o %holdSite;%a2 empurra a cabeça de %d2 para trás com seu antebraço e tenta alguns"
					+ " socos nas costelas, %d2 não conseguiu se defender e esses socos acertaram com força;%d2 escapa do clinch antes que %a1 pudesse mantê-lo preso;10;2;1;4;Socos;3;3;0;0;0;0;1;",
			"%a1 está segurando %d1 contra o %holdSite com os dedos em todo o rosto de %d2;%d2 parece desconfortável e tenta lutar, %a1 "
					+ "aproveitou e acertou alguns socos fortes nas costelas;%d2 parece desconfortável e tenta lutar, ele desliza sobre %a1 e"
					+ "se afasta do perigo %a1 ;10;2;1;4;Socos;3;3;0;0;0;0;1;"));

	public static final ArrayList<String> dirtyBoxing2 = new ArrayList<String>(Arrays.asList(
			"O canto da grade está se tornando o pior inimigo de %d1 ! %a2 está dando uma rajada de socos!;%d1 simplesmente não consegue"
					+ "escapar!;%d2 se abaixa e sai do canto.;5;0;2;1;Socos;5;3;2;0;1;12;1",
			"%a2 está lançando alguns socos fortes nas costelas de %d2 durante o clinch.;Uau. Você pode ver a dor nos olhos de %d1.;%d2 "
					+ "bloqueia.;10;0;3;4;Socos;3;3 ;0;2;0;12;12",
			"%a2 empurra %d1 e começa a lançar uma rajada de ganchos e tiros no corpo!;%d2 tropeça para trás, mas %a1 o persegue e continua"
					+ " a chuva de golpes!;%d2 segura seu oponente com força enquanto tenta esfriar a ação.;3;0;3;9;Socos;6;4;0;1;1;12;12",
			"%a1 se posiciona e lança outra série de socos!;Muitos deles estão acertando %d2 com força, quem pode estar se perguntando como "
					+ "escapar disso!;%d2 empurra seu oponente para frente e bloqueia a maior parte da ofensiva de %a1.;9;0;1;3;Socos;5;3;0;0;0;0;0;"));

	public static final ArrayList<String> dirtyBoxing3 = new ArrayList<String>(Arrays.asList(
			"Socos brutais no rosto de %d2 durante o clinch!;%d2 não pode dar muitos mais tiros como esses!;%d2 empurra %a1 com toda a sua força"
					+ " enquanto tenta manter a luta a distância .;4;-2 ;1;2;Socos;5;4;3;3;3;12;1",
			"%a2 empurra %d1 novamente no %HoldSite e começa uma combinação implacável de socos. A multidão está de pé!;%d2 não consegue escapar"
					+ " do clinch de %a1! %a1 está apenas brutalizando %d2 com socos um após o outro!;%d2 tenta bloquear os socos de %a1 ...;6;0;3;7;Socos;4;4;2;3;4;12;12",
			"%a1 é absolutamente aterrorizante com seu poder no clinch e está punindo violentamente %d2 com uppercuts!;%d2 está levando mais do que"
					+ " pode suportar. Isso pode acabar em breve se %d2 não conseguir escapar!;Nada que %d2 deve temer enquanto ele bloqueia bem;3;0;3;1;Socos;3;3;2;2;4;12;12",
			"%a2 empurra %d1 contra %holdSite e desfere alguns socos monstruosos;Alguns uppercuts colidem com o queixo de %d2! Suas pernas estão"
					+ " balançando!;%d2 bloqueia e empurra seu oponente para longe criando espaço entre eles.;8;0;2;4;Uppercuts;3;2;0;0;2;0;1;",
			"Uppercut forte de %a1!;Aquele quase quebrou o queixo de %d2! Ele foi derrubado!;%d1 é ágil o suficiente para evitar aquele! Sorte sua "
					+ "%d2! Teria terminado esta luta.;8;2;1;9;Uppercut;1;1;1;2;3;2;0;"));

	public static final ArrayList<String> grapplingPunch1 = new ArrayList<String>(Arrays.asList(
			"%a1 dá alguns socos nas costelas de %d2 enquanto o segura em duplo overhook!;%d1 recebe alguns golpes nas costelas.;%d2 parece"
					+ " não ser afetado... esses socos não carregam força alguma!;10;1;3;3;Socos;4;2;0;0;0;0;0;",
			"%a2 tenta quebrar a pegada de %d1 com alguns socos enquanto tenta empurrá-lo contra a grade.;%a2 desfere alguns socos "
					+ "que deixam marcas nas costelas de %d2.;%a2 não encontra o caminho certo.. . Ele tem que melhorar sua posição para causar "
					+ "qualquer dano real;10;0;3;3;Socos;2;2;0;0;0;0;0;"));

	public static final ArrayList<String> grapplingPunch2 = new ArrayList<String>(Arrays.asList(
			"%a2 desfere alguns socos na cabeça de %d2;Esses socos estão acertando! %d2 cobre a cabeça!;Nada disso..."
					+ " %a1 parece frustrado.;0;0;3;3;Socos;3;2;0;0;0;0;0;",
			"%a2 tenta derrubar %d1... %d2 se movimenta para trás e %a1 desfere alguns socos...;Um golpe atinge com força a "
					+ "mandíbula de %d2!;%d1 desvia e se afasta com alguns passos...;8;1;1;9;Socos;3;1;0;0;2;0;1;",
			"%a2 dá alguns socos fortes nas costelas de %d1!;%d1 mostra incômodo! %a1 está trabalhando nas costelas do "
					+ "oponente!;%d2 luta para se proteger.;10;0;3;3;Socos;4;3;0;1;0;0;0;"));

	public static final ArrayList<String> refBreakClinch = new ArrayList<String>(Arrays.asList(

			"%ref separa os lutadores e diz para eles continuarem lutando.",
			"O árbitro intervém para quebrar o clinch.",
			"%ref vê falta de atividade no clinch e separa os lutadores."));

	public static final ArrayList<String> wrestlingTD1 = new ArrayList<String>(Arrays.asList(
			"%a1 está em boa posição e quer mudar de avançar para uma queda...;%a2 pega um tornozelo e %d2 cai no tatame!;%d2 não deixa %a2 entrar nas pernas.;12;2;4;9;Tornozelo;1;1;0;0;0;6;0;",
			"%a2 recebe ganchos duplos e procura a queda...;%a2 bloqueia o joelho de %d1 e acerta uma joelhada perfeitamente executada! Bom movimento.;%d2 o empurra de volta à posição inicial.;12;2;4;9;Joelhada Tap;1;1;0;0;0;6;0;",
			"%a2 se posiciona bem e procura uma entrada para queda...;%a2 segura uma perna e derruba em %d2 para o chão!;%d1 não deixa %a1 entrar nas pernas. ;12;2;4;9;Single Leg ;1;1;0;0;0;6;0;",
			"%a1 se atira e agarra uma das pernas de %d1, tentando derrubá-lo com um single leg ;%d2 perde o equilíbrio e cai no chão;%d1 faz o sprawl e permanece em pé;9;3;0;0;Single Leg;0;0;0;1;1;5;0;",
			"%a1 faz um ótima entrada e agarra ambas as pernas de %d1, tentando derrubá-lo com um Double Leg;%a2 levantou %d2 de seus pés e o jogou no chaõ;%d1 conseguiu puxar sua perna para trás das mãos de %a1 e se afastar dele;9;3;0;0;Double Leg Takedown;0;0;0;0;0;5;0;",
			"%a2 tenta levar %d1 ao chão a partir do clinch...;Muito bem! %d2 está de volta ao chão agora.;%d2 mostra suas habilidades de sprawl e permanece de pé.;0;0;3;3;Clinch Takedown;1;1;0;0;0;5;0",
			"%a1 simula um soco nas costelas de %d1 e tenta derrubá-lo;%d1 perde o equilíbrio e cai no chão;%d2 perde o equilíbrio por um momento, mas permanece de pé após uma pequena disputa.;0;0;3;3;Clinch Takedown;1;1;0;0;0;6;0",
			"%a2 tenta levar %d1 ao chão a partir do clinch...;Muito bem! %d2 está de costas para o chão agora.;%d2 mostra suas habilidades de sprawl e permanece em pé.;0;0;3;3;Conquistar Queda;1;1;0;0;0;5;0",
			"%a1 simula um soco nas costelas de %d1 e tenta derrubá-lo;%d1 perde o equilíbrio e cai no chão;%d2 perde o equilíbrio por um momento, mas permanece de pé após uma pequena luta.;0;0;3;3;Conquistar Queda;1;1;0;0;0;6;0",
			"%a1 está em boa posição e quer avançar para uma queda...;%a2 pega um tornozelo e %d2 cai no tatame!;%d2 não deixa %a2 entrar nas pernas.;12;2;4;9;Escolha Tornozelo;1;1;0;0;0;6;0;",
			"%a2 recebe ganchos duplos e procura a queda...;%a2 bloqueia o joelho de %d1 e uma queda perfeitamente executada! Boa movimentação.;%d2 empurra %a1 de volta à posição.;12;2;4;9;Joelhada Tap;1;1;0;0;0;6;0;",
			"%a2 se posiciona bem e procura uma entrada para a queda...;%a2 segura uma perna e tropeça em %d2 para o chão!;%d1 não deixa %a1 entrar nas pernas. ;12;2;4;9;Single Leg Takedown;1;1;0;0;0;6;0;"

	));

	public static final ArrayList<String> judoTD1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta derrubar com um okuri-ashi-harai em %d1 ;bem feito %d2 cai forte no chão;%a2 falha ao tentar derrubar %d2 e ambos os homens ainda estão agarrando;12;2;4;9;Foot Sweep Takedown;1;1;0;0;0;2;0;",
			"%a2 agarra um dos braços de %d1 e tenta um arremesso de quadril;com uma torção do quadril %a1 manda %d2 para o chão como uma boneca de pano;%d2 fez bem em manter o equilíbrio e evitar cair;12;2;4;9;Arremesso do quadril;1;1;0;0;0;2;0;",
			"%a2 luta com %d1 e tenta uma raspagem de perna;%d1 cai forte no chão com %a1 em cima dele;%d1 conseguiu manter o equilíbrio e evitar a queda;12;2;4;9;Varredura de perna;0;0;0;1;1;6;0;",
			"%a1 agarra %d1 e tenta um osoto otoshi;boa queda %a1 está na posição de 100kg %d1;%d2 consegue manter o equilíbrio e evita cair;12;2;4;9;varrida de perna externa;0;0;0;1;1;13;0;",
			"%a2 e %d1 estão encostados no %site. %a2 caminha para uma queda;%d1 está deitado de costas no chão. ótima técnica de Judô mostrada!;%d2 fica de pé;12;0;4;3;Arremesso de judô;0;0;-10;0;-10;13;0;",
			"%a2 e %d1 estão clinchados contra a %site. %a2 se movimenta para uma queda;%d1 é jogado no chão, mas volta a se levantar;%d2 permanece em pé;12;0;4;3;Arremesso de judô - ineficaz;0;0;-10;0;-10;0;0;",
			"%a2 e %d1 estão clinchados contra a %site. %a2 martela o rosto de %d2 e segura a perna de %d2;%d1 está de costas após essa queda;%d2 fica de pé e luta contra a queda;12;-5;1;3;Judo trip clinch - efetivo;2;2;-10;-10;-10;6;0;",
			"%a2 vai para uma queda kani-basami. isso é incomum;%d1 está caído depois dessa queda e eles estão lutando por posição. %a1 leva a vantagem;%a1 está de costas depois dessa tentativa;12;5;1;4;Judô - queda com tesoura;0;0;-10;-10;-10;5;3;",
			"%a1 atira e agarra o tornozelo de %d1 tentando derrubá-lo com um kibisu-gaeshi;%a2 pega o tornozelo de %d1 com uma mão e empurra seu corpo com a outra forçando %d2 para o chão;%d2 faz um belo sprawl e permanece em pé;9;3;0;0;Heel Trip Reverse;0;0;0;1;1;5;0;",
			"%a1 finge alguns socos e avança em direção a %d2 tentando derrubá-lo com um de-ashi-barai;%d1 perde o equilíbrio e cai com força no chão;%d2 empurra %a1 e gira para longe, mantendo-se fora do alcance do golpe;9;4;0;0;Avanço da Varredura de Pernas;0;0;0;1;1;2;1;",
			"%a1 tenta uma queda de rasteira em %d1 ;muito bem %d2 cai forte no chão;%a1 não consegue derrubá-lo e os dois lutadores ainda estão de pé;9;4;0;0;Queda de rasteira de pés;0;0;0;1;1;2;1;",
			"%a2 agarra um dos braços de %d1 e tenta um o-goshi;%d1 caiu de costas com força;%d2 fez bem em manter o equilíbrio e evitar cair;9;5;0;0;arremesso de quadril;0;0;0;1;2;2;1;",
			"%a2 luta com %d1 e tenta um kouchi-gari;%d1 cai com força no tatame com %a1 em cima dele;%d1 conseguiu manter o equilíbrio e se afastar de %a2 ;9;4;0;0;Varredura da perna interna;0;0;0;1;1;15;1;",
			"%a1 agarra %d1 e tenta um kari-ashi;boa queda %a1 está no 100kg sobre %d1 ;%d2 consegue manter o equilíbrio e evitar a queda;9;3;0;0;varrida de perna externa;0;0;0;1;1;13;0;"));

	public static final ArrayList<String> breakClinch = new ArrayList<String>(Arrays.asList(
			"%a1 empurra %d2 tentando manter a luta a distância;%d2 afasta-se para trás e %a1 circula para chegar ao centro do %site;%d2 não quer quebrar o clinche porque ainda está lutando com %a1;0;0;3;9;Break Clinch;0;0;0;0;0;1;0",
			"%a2 não quer fazer uma luta aguarrada, %d1 tenta o segurar...;Boa movimento de %a2 que colocou uma distância entre eles;%d1 empurra %a2 para frente e não permite que ele quebre o clinch.;0;0;3;9;Break Clinch;0;0;0;0;0;1;0",
			"%a1 tenta encolher os ombros para sair do clinch. ;%a2 circula e escapa dos ganchos de %d1. Belo trabalho de sair dessa posição.;%d2 está determinado a trabalhar a partir do clinch. Ele forçou e conseguiu manter sua posição.;0;0;3;9;Break Clinch;0;0;0;0;0;1;0;"

	));

	public static final ArrayList<String> gnp1 = new ArrayList<String>(Arrays.asList(
			"%a1 dá uma rajada de socos em %d2...;Muitos deles estão acertando o rosto de %d2;%d2 está se defendendo bem. Nenhum deles acertou.;5;2;7;8;GnP;5;4;1;0;0;0;0",
			"%a2 tenta lançar alguns socos em %d1;Pouco efeito. Muitos deles estão acertando a defesa de %d2;%d2 é capaz de fazer a guarda fechada e contra-atacar os socos de %a1.;9;2;8;10;GnP ;3;1;0;0;0;0;6",
			"%a1 se posiciona e lança uma chuva de socos.;%a1 está montado e seus socos atingem com força o abdômen de %d2;%d2 se cobre bem;11;2;10;7;GnP;4;2;0;0;0;4;0",
			"%a1 posiciona-se e lança uma muitos socos.;%a1 está montado e seus socos atingem com força as costelas de %d2;%d2 se cobre bem;10;2;10;7;GnP;4;2;0;0;0;4;0",
			"%a1 desfere alguns socos em %d2;Socos fracos. Ele precisa melhorar sua posição!;%d2 segura os braços de %a1 e bloqueia os socos!;1;3;7;10;GnP;4;3;0;-1;-2;0;0",
			"%a1 desfere alguns socos em %d2;Socos fracos. Ele precisa melhorar sua posição!;%d2 se cobre bem e depois rola no chão. Ótima inversão!;1;1;7;8;GnP;4;2;0;0;0;0;9",
			"%a1 dá muitos socos;alguns golpes passam.;com pouco efeito. %d2 está fazendo um ótimo trabalho se protegendo.;0;2;7;10;GnP;3;1;-1;-1 ;-2;0;0",
			"Alguns socos com pouca força de %a2;Eles estão incomodando %d2, embora não o estejam machucando.;%d1 não recua.;0;2;7;10;GnP;3;2;-1;-1;-2;0;0",
			"Socos no corpo de %a1;Golpes sólidos no abdômen de %d2.;%d2 se defende.;11;1;8;7;GnP;2;2;-2;0;-2;0;0"));

	public static final ArrayList<String> gnp2 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta abrir a guarda de %d2...;Grandes bombas por cima por %a1. %d2 não consegue se cobrir agora!;%d2 quebra a trava e se protege dos socos de %a2;1;0;10;7;GnP;6;4;2;0;1;0;0",
			"%a2 consegue uma boa posição no chão. ..;e que rajada incrível! Ele está apenas chorando em %d1! O árbitro está dizendo que vai parar se %d1 não se defender!;%d2 segura %a1 arma e contra-ataca os socos do oponente.;6;0;7;10;GnP;5;5;2;0;2;0;0",
			"%a2 tenta abrir a defesa de %d1 fingindo alguns socos.;Ele está socando agressivamente e repetidamente %d2 na lateral da cabeça;%d1 envolve seus braços ao redor dos braços de %a2 e contra-ataca os socos.;1;0;10;7;GnP;4;4;2;0;1;0;0",
			"%a1 se mantém sobre %d2;Bons socos no corpo de %d2.;%d1 o impede de lançar golpes.;9;1;7;13;GnP;3;3;0;0;-1;0;0",
			"%a1 simula alguns socos;então acerta um grande soco no rosto de %d2!;%d2 o amarra.;0;1;8;7;GnP;1;1;0;0;2;0;0",
			"%a2 dá alguns socos no rosto de %d1;Tiros certeiros!;Bloqueado por %d2.;0;1;7;13;GnP;4;4;0;0;2;0;0",
			"%a1 soca %d2 de forma agressiva e repetida.;Ele precisa fazer algo logo ou o árbitro vai parar a luta!;Bom trabalho %d2 bloqueando e desviando os golpes.;0;0;10;10;GnP;5;4;2;0;1;0;0",
			"Socos bonitos de %a1 no chão;Eles poderiam cobrar seu preço em %d2.;desviados por %d2.;0;1;10;7;GnP;3;3;1;0;0;0;0"));

	public static final ArrayList<String> gnp3 = new ArrayList<String>(Arrays.asList(
			"%a1 quer finalizar seu oponente no chão;%a2 afunda o rosto de %d1 com uma enorme pancada de direita! Que "
					+ "impacto!;%a1 não consegue encontrar uma brecha na guarda do adversário!;6;-1;10;7;GnP;1;1;2;2;2;0;0",
			"%a1 move-se para melhorar sua posição no chão...;%a1 desfere violentamente golpes de martelo no rosto de "
					+ "%d2!;%a1 envolve seus braços em volta dos oponentes e tenta trocar de posição;1;0;10;7;GnP ;3;3;1;2;3;0;14",
			"%a2 se inclina para trás...;Ele acerta o rosto de %d1 com um soco enorme! Ai!;%d2 olha para ele com cautela."
					+ ";0;0;10;7;GnP;1;1;1;1;2;0;0",
			"%a2 está tentando acabar com esta luta com golpes;Ele começa a bater em %d1, que mal está se escondendo!;%d2 "
					+ "antecipa seus movimentos e evita o perigo.;0;-1;10;7;GnP;5;4;1;1;3;0;15",
			"%a2 dispara um monte de socos na cabeça de %d2!;Isso é ruim! %a2 está apenas batendo na cabeça de %d1 como se"
					+ " fosse um boneco de treinamento! O árbitro olha ansioso!;Os socos vão longe.;0;0;10;7;GnP;5;4;1;1;2;0;0",
			"%a1 aplica cotoveladas...;Ele está rasgando o rosto de %d2 com aquelas cotoveladas brutais! %d2 precisa fazer "
					+ "alguma coisa! O árbitro está ameaçando parar!;%d2 esta se movimentando bem e não está se tornando um alvo "
					+ "fácil.;0;0;10;8;GnP;5;5;2;1;1;0;0"));

	public static final ArrayList<String> inRearMountMoves = new ArrayList<String>(Arrays.asList(
			"%d2 deu as costas para %a1 que está tentando acertar um gancho!;%a1 tem um gancho!;%d2 luta no chão tentando quebrar o controle de %a2;0;-2;10;10;Movimento de solo;1;1;0;0;0;7;0",
			"%a2 tenta passar um gancho!;A coisa piora para %d2! %a2 tem um gancho e continua trabalhando!;%d2 rola no chão e consegue fazer meia-guarda!;0;-2;10;10;Movimento no solo;1;1;0;0;0;7;15"

	));

	public static final ArrayList<String> inRearMountOneHookMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tem um gancho e está tentando pegar o segundo! Se ele conseguir, as coisas vão ficar muito ruins"
					+ " para %d2.;Muito bem! %a2 agora tem dois ganchos! O fim pode estar próximo!;%d2 usa sua perna como "
					+ "alavanca e consegue se manter seguro por enquanto.;0;-2;0;0;Ground move;1;1;0;0;0;7;0"

	));

	public static final ArrayList<String> inRearMountTwoHooksMoves = new ArrayList<String>(Arrays.asList(
			"%a2 está nas costas com dois ganchos encaixados! Ele está trabalhando em um %d2 desesperado, que tenta se defender e"
					+ " escapar daquela posição.;%a2 se move procurando encaixar um mata-leão e finalizar.;%d2 está segurando os braços do "
					+ "oponente defendendo bem.;0;0;10;10;Movimento no solo;0;0;0;0;0;0;0;",
			"%a2 tentativamente procurar uma maneira de finalizar seu oponente! Isso é um pesadelo para %d2!;%a2 tem um de seus braços"
					+ " sobre o ombro de %d1 e está pronto para um mata-leão!;%d2 rola no chão e ele é olhando para o teto enquanto %a1 está de costas, mas com apenas um gancho!;0;0;10;10;Ground move;0;0;0;0;0;0;17;",
			"%a2 procura tentivamente uma maneira de finalizar seu oponente! Isso é um pesadelo para %d2!;%d2 fica de quatro apoios e "
					+ "%a2 está pronto para abrir caminho para a vitória com uma sequênciade socos!;%d2 rola no chão e ele acaba sendo totalmente"
					+ " montado por %a1;0;0;10;10;Ground move;0;0;0;0;0;0;4;"

	));

	public static final ArrayList<String> defInRearMountMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tem %d2 controlando suas costas enquanto está no chão. Ele tenta rolar e encontrar uma fuga...;Mostrando algumas"
					+ "habilidades no solo, ele faz a transição para a posição de 100kg.;%d2 é incapaz de se mover sob o controle de %a2.;"
					+ "0;2;10;8;Movimento no solo;1;1;0;0;0;14;0",
			"%a2 tem %d2 controlando suas costas enquanto está no chão. Ele tenta rolar e encontrar uma fuga...;Mostrando "
					+ "algumas habilidades no solo %a2 consegue escapar dessa posição e ficar de pé ao longo de %d2;%d2 é incapaz de "
					+ "se mover sob o controle de %a2.;0;2;8;6;Movimento no solo;1;1;0;0;0;1;10"

	));

	public static final ArrayList<String> defInRearMountOneHookMoves = new ArrayList<String>(Arrays.asList(
			"%a2 está tentando não dar as costas.;%a2 segura o braço de %d1 sobre o ombro e depois rola no chão. Movimento incrível "
					+ "para conseguir uma meia guarda!;%d2 tenta usar alguns de seus movimentos na luta de chão,"
					+ " mas %d2's é inteligente o suficiente para combatê-lo.;0;3;6;8;Ground move;1;1;0;0;0;13;0",
			"%a2 tem que usar algumas de suas habilidades para escapar com segurança desta posição...;%a1"
					+ " usa suas habilidades de chão para liberar uma de suas pernas enquanto trabalha no chão.;%a2 não "
					+ "consegue encontrar uma maneira de escapar.;0;2;8;6;Movimento de solo;1;1;0;0;0;17;0"));

	public static final ArrayList<String> defInRearMountTwoHooksMoves = new ArrayList<String>(Arrays.asList(
			"%a2 está tentando não dar as costas.;%a2 segura o braço de %d1 sobre o ombro e depois rola no chão. Movimento incrível para "
					+ "conseguir uma meia guarda!;%d2 tenta usar alguns de seus movimentos no chão, mas %d2's é inteligente o suficiente para combatê-lo.;0;3;6;8;Ground move;1;1;0;0;0;13;0",
			"%a2 tem que usar algumas de suas habilidades para escapar com segurança desta posição...;%a1 usa suas habilidades de jiu"
					+ " jitsu para liberar uma de suas pernas enquanto trabalha no chão.;%a2 não consegue encontrar uma maneira de escapar"
					+ " isto.;0;2;8;6;Movimento de solo;1;1;0;0;0;17;0"

	));

	public static final ArrayList<String> inFullMountMoves = new ArrayList<String>(Arrays.asList(
			"%a1 tenta melhorar sua posição no chão...;%a2 está em ótima posição para começar uma bela rodada de "
					+ "socos!;%d1 tenta rolar no chão...;0;2;7;10;Movimento de solo;0;0;0;0;0;0;10",
			"%d1 tenta rolar para o lado e chegar à meia-guarda...;%a1 rola %d1 para o baixo e pega as costas!;%d1"
					+ " cria espaço suficiente para controlar a perna de %a1.;0;0;0;0;Movimento de solo;0;0;0;0;0;7;15;",
			"%d1 tenta rolar para o lado e prender %a1 na guarda...;%a1 rola e pega as costas!;%d1 levanta o quadril e "
					+ "vai para guarda fechada.;0;0;0;0;Movimento de solo;0;0;0;0;0;7;6;",
			"%a2 tenta manter sua posição enquanto procura talvez espaço pra conectar alguns socos...;%a1 controla a"
					+ " situação apesar de %d1 fazer esforços para escapar da montada.;%d2 luta e libera sua perna!;0;0;0;0;Movimento de"
					+ " solo;0;0;0;0;0;0;15;",
			"%a2 tenta manter sua posição enquanto procura talvez começar um ground and pound...;%a1 controla a situação apesar de %d1"
					+ " fazer esforços para escapar damontada.;%d2 luta e empurra seu oponente talvez um pouco ansiosamente;0;0;10;13;Movimento no solo;0;0;0;0;0;0;0;",
			"%d2 tenta escapar da montada...;%a1 não é pego de surpresa e se move para a lateral para manter sua posição superior.;%d2"
					+ " luta e empurra seu oponente talvez um pouco ansiosamente;0;0;10;13;Movimento no solo;0;0;0;0;0;13;0;"

	));

	public static final ArrayList<String> defInFullMountMoves = new ArrayList<String>(Arrays.asList(
			"%a1 tenta rolar no chão...;Ele consegue uma raspagem!;%d2 sabe como manter sua vantagem no chão.;0;0;8;10;Movimento "
					+ "no chão;0;0;0;0;0;6;8",
			"%a2 tenta se mover no chão e escapar da montada!;Ele passa para a meia-guarda com sucesso!;%d1 não quer perder sua posição"
					+ " de vantagem e luta para manter a montada.;10;0;8;5;Movimento no solo;0;0;0;0;0;16;0;",
			"%a1 tenta rolar para o lado e prender %d1 em sua guarda...;%a1 se move para meia-guarda.;%d1 mantém bom controle e permanece"
					+ " montado.;0;0;0;0;Movimento no solo ;0;0;0;0;0;16;0;",
			"%a1 tenta rolar para o lado e prender %d1 em sua guarda...;%a1 levanta o quadril e move-se para a guarda fechada.;%d1 mantém "
					+ "bom controle e permanece montado.;0;0;0;0;Movimento de solo;0;0;0;0;0;9;0;",
			"%a1 tenta rolar para o lado e prender %d1 em sua guarda...;%a1 levanta o quadril e move-se para a guarda fechada.;%d1 mantém bom"
					+ " controle e permanece montado.;0;0;0;0;Movimento de solo;0;0;0;0;0;8;0;",
			"%a2 está usando algumas de suas habilidades de grappling para escapar disso...;Ele empurra o joelho de %d2 e tenta rolar! Bela movimentação para entrar na meia-guarda!;%d1 empurra %a1 para baixo e impede suas tentativas de fuga;0;0;8;5;Movimento no Solo;0;0;0;0;0;15;0;"

	));

	public static final ArrayList<String> inSideMountMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tenta se mover pra montada!;Boa movimento. Ele está montado agora.;%d2 não permitirá que ele tome esta posição facilmente"
					+ ".;0;0;10;13;Movimento no solo;0;0;0;0;0;4;13",
			"%a1 procura passar para a montada...;%a2 desliza o joelho e atinge a posição de montada! Posição difícil para %d1.;%d2 cria "
					+ "espaço e se levanta.;0;0;0;0;Passagem de montagem lateral;0;0;0;0;0;4;1;",
			"%a1 procura montar %d1...;%a1 desliza o joelho e consegue montar.;%d1 vê uma abertura e trava o oponente na meia-guarda.;0;0;0;"
					+ "0;Movimento no chão;0;0;0;0;0;4;15;",
			"%a1 procura montar %d1...;%a1 desliza o joelho e consegue montar.;%d1 aproveita o excesso de confiança do oponente e o prende "
					+ "em guarda fechada.;0;0;0;0;Ground mover;0;0;0;0;0;4;5;",
			"%a1 procura montar %d1...;%a1 desliza o joelho e consegue montar.;%d1 aproveita o excesso de confiança do oponente e o prende"
					+ " em guarda fechada.;0;0;0;0;Ground mover;0;0;0;0;0;4;6;"));

	public static final ArrayList<String> defInSideMountMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tenta mostrar algumas habilidades de jiu jitsu;%a1 coloca %d2 na meia-guarda.;%a2 usa sua força para "
					+ "manter %d2 em desvantagem;0;2;10;8;Movimento no solo;0;0;0;0;0;16;14",
			"%a1 tenta prender %d1 em sua guarda.;%a1 consegue avançar para meia-guarda.;%d1 mantém o controle e permanece "
					+ "montado de lado.;0;0;0;0;Movimento no chão;0;0;0;0;0;16;0;",
			"%a1 tenta amarrar %d1 em sua guarda.;%a1 consegue fechar a guarda.;%d1 mantém o controle e permanece montado de"
					+ " lado.;0;0;0;0;Movimento no solo;0;0;0;0;0;9;0;",
			"%a1 tenta prender %d1 em sua guarda.;%a1 consegue fechar a guarda.;%d1 mantém o controle e permanece na posição"
					+ " de 100kg.;0;0;0;0;Movimento no solo;0;0;0;0;0;10;0;"

	));

	public static final ArrayList<String> inHalfGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a1 empurra a perna de %d2 e tenta passar para a montada.;Bom movimento de %a2 que está na montada agora!"
					+ "%d2 está com problemas!;%d2 rola e agora está na meia-guarda sobre %a1. Boa raspagem .;0;0;0;0;Movimento no solo;0;0;0;0;0;4;16",
			"%a1 empurra a perna de %d2 e tenta mover-se para a montada.;Bom movimento de %a2 que está na montada! %d2 está"
					+ " com problemas agora!;%d2 envolve as pernas enquanto segura a cabeça de %a1... boa guarda!;0;2;8;7;Movimento no solo;0;0;0;0;0;4;15",
			"%a2 tenta liberar a perna...;Ele se move para a posição de 100kg!;%d2 não permite nenhum movimento! Ele está "
					+ "esfriando a luta no chão.;0;2;10;7;Movimento no chão;0;0;0;0;0;13;0",
			"%a2 senta-se sobre os joelhos e empurra a perna de %d2!;%a1 é capaz de afastar a perna e então pula para o lado"
					+ ";%d2 fecha as pernas em torno da perna de %a1. %a2 não é capaz de se afastar agora!;0;0;13;15;Mover no chão;0;0;0;0;0;13;0;",
			"%a2 dá alguns socos fracos e tenta escapar!;%d2 está se defendendo! %a2 tenta forçar a situação e %d2 desajeitadamente dá as "
					+ "costas!;%a2 é contra-atacado por %d1.;0;0;7 ;14;Movimento de solo;0;0;0;0;0;7;0;",
			"%a2 dá alguns socos fracos e tenta escapar!;%d1 não consegue parar %d2 habilidades de solo e %a1 se move para a posição de "
					+ "100kg!;%d1 rola sobre si mesmo e se levanta enquanto %a1 rola de costas. ;0;0;0;0;Movimento no solo;0;0;0;0;0;13;3;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para a lateral.;%a1 passa momentaneamente, mas %d1"
					+ " recupera a meia-guarda.;0;0;0;0;Movimento no chão ;0;0;0;0;0;13;0;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para a posição de 100kg.;%a1 passa momentaneamente,"
					+ " mas %d1 vê e abre e o prende na guarda fechada.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;5;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para a posição de 100kg.;%a1 passa momentaneamente,"
					+ " mas %d1 vê e abre e o prende em guarda total.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;6;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e vai para a posição de 100kg.;%d1 tem a guarda muito boa e "
					+ "ele não consegue passar.;0;0;0;0;Ground mover;0;0;0;0;0;13;0;",
			"%a2 tenta atacar no chão...;Ele libera sua perna e agora está controlando %d2 na posição de 100kg!;%d2 envolve sua perna em "
					+ "torno de %a1 perna e o impede de se mover.;0;0;10;7;Movimento de solo;0;0;0;0;0;13;0;",
			"%a2 tenta sair pelo lado...;Ele libera sua perna e agora está controlando %d2 na posição de 100kg!;%d2 envolve sua perna em "
					+ "torno de %a1 perna e o impede de se mover.;0;0;13;10;Movimento de solo;0;0;0;0;0;13;0;",
			"%a1 tenta liberar sua perna;%a1 usa um pouco de sua habilidade saltando para fora da guarda de %d2. Ele se move rapidamente "
					+ "para conquistar a posição!;%d1 se move rapidamente e ambos os lutadores trocam alguns socos fracos enquanto se levantam.;"
					+ "0;0;0;0;Movimento de solo;0;0;0;0;0;13;1;",
			"%a1 tenta liberar sua perna;%a1 usa um pouco de sua habilidade saltando para fora da guarda de %d2. Ele se move rapidamente "
					+ "para a posição de 100kg!;%d1 se move rapidamente e ambos os lutadores trocam alguns socos fracos enquanto se levantam.;"
					+ "0;0;0;0;Movimento de solo;0;0;0;0;0;13;1;",
			"%a1 tenta liberar a perna...;%a1 usa um pouco de sua habilidade toreando a guarda de %d2. Ele se move rapidamente para a "
					+ "montada!;%d2 rola no chão e se move para a posição de 100kg! Movimentação incrível! ;0;0;0;0;Movimento de solo;0;0;0;0;0;13;14;"

	));

	public static final ArrayList<String> defInHalfGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a1 empurra a perna de %d2 e tenta mover-se para a montada.;Bom movimento de %a2 que agora está na montada! %d2 está com"
					+ " problemas agora!;%d2 rola e agora está na meia-guarda sobre %a1. Boa raspagem.;0;0;0;0;Movimento de chão;0;0;0;0;0;4;16",
			"%a1 empurra a perna de %d2 e tenta mover-se para a montada.;Bom movimento de %a2 que está na montada! %d2 está com problemas"
					+ " agora!;%d2 envolve as pernas enquanto segura a cabeça de %a1... Guarda bem fechada!;0;2;8;7;Golpe de chão;0;0;0;0;0;4;15 ",
			"%a2 tenta liberar sua perna...;Ele se move pra posição de 100kg!;%d2 não permite nenhum movimento aqui! Ele tá amarrando a"
					+ " luta no chão.;0;2;10;7;Ground move;0;0;0;0;0;13;0",
			"%a2 senta-se sobre os joelhos e empurra a perna de %d2!;%a1 é capaz de afastar a perna e então pula para o lado.;%d2 fecha"
					+ " as pernas ao redor da perna de %a1. %a2 não é capaz de se afastar agora!;0;0;13;15;Movimento de solo;0;0;0;0;0;13;0;",
			"%a2 dá alguns socos e tenta escapar!;%d2 está se protegendo! %a2 tenta forçar a situação e %d2 desajeitadamente dá as "
					+ "costas!;%a2 é contra-atacado por %d1.;0;0;7;14;Movimento de solo;0;0;0;0;0;7;0;",
			"%a2 dá alguns socos e tenta escapar!;%d1 não consegue parar as habilidades de %a1 no %chão que se move para posição de 100kg!;%d1 "
					+ "rola sobre si mesmo e se levanta enquanto %a1 rola de costas.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;3;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para a lateral.;%a1 passa momentaneamente, mas"
					+ " %d1 recupera a meia-guarda.;0;0;0;0;Movimento no chão;0;0;0;0;0;13;0;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para posição de 100kg.;%a1 passa momentaneamente,"
					+ " mas %d1 vê e abre e o prende em na guarda fechada.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;5;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e se move para montar lateralmente.;%a1 passa momentaneamente,"
					+ " mas %d1 vê e abre e o prende em guarda total.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;6;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e vai para a lateral.;%d1 tem uma guarda muito boa e ele não "
					+ "consegue passar.;0;0;0;0;Movimento no chão ;0;0;0;0;0;13;0;",
			"%a2 tenta passar pra lateral...;Ele libera sua perna e agora está controlando %d2 da na posição de 100kg!;%d2 envolve sua perna"
					+ " em torno de %a1 e o impede de se mover.;0;0;10;7;Movimento de solo;0;0;0;0;0;13;0;",
			"%a2 tenta montar de lado...;Ele libera sua perna e agora está controlando %d2 posição de 100kg;%d2 envolve sua perna em torno de"
					+ " %a1 perna e o impede de se mover.;0;0;13;10;Movimento de solo;0;0;0;0;0;13;0;",
			"%a1 tenta liberar sua perna;%a1 usa um pouco de sua habilidade saltando da guarda de %d2. Ele se move rapidamente para o lado"
					+ " montado!;%d1 se move rápido e ambos os lutadores trocam alguns socos fracos enquanto se levantam.;0;0;0;0;Movimento no "
					+ "solo;0;0;0;0;0;13;1;",
			"%a1 tenta liberar sua perna;%a1 usa um pouco de sua habilidade saindo da guarda de %d2. Ele se move rapidamente para a posição "
					+ "de 100kg!;%d1 se move rápido e ambos os lutadores trocam alguns socos fracos enquanto se levantam.;0;0;0;0;Movimento no solo;0;0;0;0;0;13;1;",
			"%a1 tenta liberar sua perna...;%a1 usa um pouco de sua habilidade saltando da guarda de %d2. Ele move-se rapidamente para "
					+ "a montada!;%d2 rola no chão e move-se para a posição de 100kg! Incrível!;0;0;0;0;Movimento no solo;0;0;0;0;0;13;14;"

	));

	public static final ArrayList<String> inOpenGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tenta se mover para a montada;%a2 consegue;O grappling de %a2 não é suficiente para lhe dar qualquer vantagem no chão;0;2;10;8;Movimento de chão;0;0;0;0;0;4;5",
			"%a2 move-se no chão;%a1 move-se para posição de 100kg;%a2 não consegue tirar nenhuma vantagem no chão;0;2;10;8;Movimento no solo;0;0;0;0;0;13;5",
			"%a2 tenta pular para a lateral de %d2.;%d1 fechou a guarda em torno de %a1.;%d1 pula e mostra algumas habilidades de chão enquanto se posiciona para continuar a luta no na posição de 100kg.;0;0;0;0;Movimento de solo;0;0;0;0;0;13;10;",
			"%a1 empurra %d1 contra o %HoldSite e depois tenta melhorar sua posição.;%a2 se move e tenta liberar a perna! %d2 não permite isso mas %a1 consegue entrar na meia guarda aqui.;%d1 luta não permitindo que %a1 melhore sua posição.;0;0;10;13;Movimento no solo;0;0;0;0;0;15;0;",
			"%a1 tenta passar para a meia-guarda...;%d1 não consegue impedir o adversário de passar. %a2 procura trabalhar na meia-guarda.;%d1 guarda muito boa e ele não consegue passar.;0;0;0;0;Movimento de solo;0;0;0;0;0;15;0;",
			"%a1 tenta passar para a meia-guarda...;%d1 não consegue impedir o adversário de passar. %a2 procura trabalhar da meia-guarda.;%d1 fecha a guarda para impedir a passagem.;0;0;0;0;Movimento de solo;0;0;0;0;0;15;6;",
			"%a2 se move no chão..;Ele fica na meia-guarda.;...ele não avança.;0;0;10;8;Movimento no chão;0;0;0;0;0;15;5",
			"%a2 se move no chão...;..e vai para a meia-guarda.;Ele continua na guarda aberta.;0;0;10;8;Movimento no chão;0;0;0;0;0;15;5",
			"%a2 tenta melhorar a posição.;Ele libera uma perna.;%d2 ajusta e fecha a guarda.;0;0;10;8;Movimento no chão;0;0;0;0;0;15;6"

	));

	public static final ArrayList<String> defInOpenGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tenta fechar a guarda em torno de %d2;Ele consegue!;Ele não consegue;0;2;0;0;Movimento de solo;0;0;0;0;0;10;9"

	));

	public static final ArrayList<String> inClosedGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a1 tenta melhorar sua posição no chão...;%a2 quebra a guarda fechada de %d1 e vai para a meia-guarda;%d2 segura a cabeça de "
					+ "%a1 contra o queixo na guarda fechada.;0;2;7 ;10;Movimento de solo;0;0;0;0;0;13;6",
			"%a2 luta no chão e tenta passar a guarda de %d1...;%a1 está em %d2 guarda aberta agora;%d2 não quer liberar o oponente e %a2 "
					+ "continua em guarda fechada;0;2;10;7;Movimento no solo;0;0;0;0;0;5;6",
			"%a2 tenta escapar da guarda fechada;%a2 consegue e agora está na guarda aberta... demora um segundo para respirar;%a1 se aventura"
					+ " no chão.;0;2;7;10;Movimento no chão;0;0;0;0;0;5;6",
			"%a2 tenta melhorar sua posição no chão enquanto senta de joelhos e tenta quebrar a guarda fechada.;%a1 finge alguns socos e depois"
					+ " desliza uma perna para conseguir a meia guarda.;%d2 se inclina e consegue os braços de %a1 enquanto ele o traz para o chão novamente.;11;0;10;7;Movimento no solo;0;0;0;0;0;15;0;",
			"%a2 tenta escapar da guarda fechada...;%a2 luta para liberar a perna e pula para meia-guarda!;%d2 espera o momento e tenta rolar! "
					+ "Tarde demais para %a1! Ele está invertido e agora %d1 está na meia guarda!;0;0;0;0;Golpe de chão;0;0;0;0;0;15;16;",
			"%a2 usa algumas de suas habilidades de wrestling para escapar da guarda fechada!;Após alguns movimentos hesitantes, ele salta para "
					+ "a posição de 100kg! A multidão está torcendo por ele!;%d1 segura %a1 e o impede de se mover para uma posição melhor!;0;0;7;10;Mover no chão;0;0;0;0;0;13;0;",
			"%a1 procura se posicionar para cima e abrir a guarda de %d1... ;%a1 força %d1 a abrir sua guarda.;%d1 tem uma guarda sólida e mantém"
					+ " os tornozelos travados.;0;0;0;0;Movimento no chão ;0;0;0;0;0;5;0;",
			"%a1 está tentando passar a guarda de %d1...;%a1 libera os quadris e se move para a meia-guarda.;%d1 tem uma guarda sólida e mantém "
					+ "os tornozelos travados.;0;0;0;0;Movimento no chão ;0;0;0;0;0;15;0;",
			"%a1 tenta passar a guarda de %d1...;%a1 consegue liberar a perna e vai para a meia-guarda.;%a1 passa momentaneamente, mas %d1 "
					+ "recupera a guarda total.;0;0;0;0;Movimento no chão ;0;0;0;0;0;15;0;"

	));

	public static final ArrayList<String> defInClosedGuardMoves = new ArrayList<String>(Arrays.asList(
			"%d2 está em guarda fechada... %a2 tenta rolar no chão!;Boa raspagem! Ele agora está montado em cima de %d1!;%d1 usa a perna"
					+ " para manter a posição no chão;0;1;8;10;Movimento no Solo;0;0;0;0;0;4;10"

	));

	public static final ArrayList<String> inButterflyGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a1 procura passar a guarda de %d2...;%a2 empurra para baixo a perna de %d2 e passa para a meia-guarda.;%d1 bloqueia"
					+ " a mão de %a2 e mantém sua posição.;0;0;0;0;Passe Borboleta;0;0;0;0;0;15;0;",
			"%a1 procura passar a guarda de %d2...;%a2 tira o gancho e passa para a meia-guarda de %d1.;%a2 se abre e acaba sendo "
					+ "raspado!;0;0;0;0;Passagem Borboleta;0;0;0;0;0;15;9;"

	));

	public static final ArrayList<String> defInButterflyGuardMoves = new ArrayList<String>(Arrays.asList(
			"%d2 está na guarda borboleta de %a2...;%a2 estende as pernas e raspa %d1 ! Ele ganha "
					+ "a posição de 100kg.;%d1 chuta a perna para trás e reinicia.;0;1;8;10;Movimento de Solo;0;0;0;0;0;13;0;",
			"%d2 está na guarda borboleta de %a2...;%a2 estende as pernas e raspa %d1! Ele ganha a a"
					+ " posição de 100kg.;%d1 movimenta os quadris e se livra dos ganchos.;0;1;8 ;10;Movimento no solo;0;0;0;0;0;13;10;"

	));

	public static final ArrayList<String> slamOut = new ArrayList<String>(Arrays.asList(
			"%a2 tenta quebrar a guarda batendo %d1 contra o chão!;Depois de algumas batidas, %d2 abre guarda! Que demonstração"
					+ " de poder impressionante!;%d1 não permite que %a1 escape. Ele está apertando a %movename;10;0;0;0;Slam;1;1;0;1;1;2;0;",
			"%a1 levanta seu oponente do chão com muita força! E ele cai!;%d1 perde a guarda após aquele golpe incrível contra o"
					+ " chão! Que pancada!;%d1 não abre a guarda de %a1 está correndo contra o tempo!;9;0;0;0;Slam;1;1;0;1;1;5;0;"));

	public static final ArrayList<String> lockingSubmission = new ArrayList<String>(Arrays.asList(
			"%a2 está bloqueando aquela tentativa de %movename...", "Bloqueio fragil!",
			"Você pode ver a dor refletida nos olhos de %d2...", "Esse %movename de %a1 parece ser indefensável",
			"%d2 luta para se libertar", "Está segurando firme", "Aquele %movename parece apertado..."));

	public static final ArrayList<String> subRefStoppage = new ArrayList<String>(Arrays.asList(
			"%ref manda %a1 largar a finalização! A luta acabou! %d2 não queria bater, mas o árbitro decidiu que não conseguiria escapar!",
			"%a2 aperta com força e %d1 se recusa a bater... %ref pula e acaba com a luta!"));

	public static final ArrayList<String> closedGuardSub1 = new ArrayList<String>(Arrays.asList(
			"%a2 vai para a guarda alta e tenta fechar a chave de braço!;Incrível! %d2 está batendo antes de saber o que aconteceu.;%d1 "
					+ "consegue se defender, rola no chão e se levanta rapidamente.;13;1;10;8;chave de braço;1;1;0;0;0;10;3",
			"%a2 tenta uma chave de braço por baixo!;Foi incrível! %d2 está batendo antes de saber o que aconteceu.;%d1 consegue se defender"
					+ " e se move para a posição de 100kg.;13;1;10;11;chave de braço;1;1;0;0;0;10;14",
			"%a1 com uma tentativa de triângulo!;Ele encaixa! %d1 está com problemas! Ele luta por alguns segundos antes de bater, que linda "
					+ "finalização!;%d1 se posiciona e consegue defender o triângulo.;0;1;10;8;Triângulo;1;1;0;0;0;0;0;",
			"%a1 desliza as pernas para o alto e tenta aplicar um triângulo!;%d1 não percebeu o perigo que corria e é pego! Ele sabe agora e"
					+ " bate rápido!;%d1 se move para o lado e consegue passar para a posição de 100kg!;0;1;10;5;Triângulo;1;1;0;0;0;0;14;",
			"%a1 senta-se e coloca um braço em volta do pescoço de %d2!;Ele enrola uma guilhotina apertada! %d2 tenta rolar, mas não consegue "
					+ "aliviar a pressão em seu pescoço. %d2 é forçado a bater naquela guilhotina! A luta acabou , simples assim!;%d2 empurra"
					+ " %a1 de volta ao chão.;0;2;8;10;Guilhotina;1;1;0;0;0;0;0;",
			"%a2 se move por baixo e rola para uma chave de joelho!;%a1 estende os quadris e %d2 está fazendo uma careta de dor. %d1 não aguenta"
					+ " mais a dor e bate!;%d2 bloqueia a tentativa e aproveita a oportunidade para entrar na"
					+ " meia guarda.;17;2;10;8;Joelho;1;1;0;0;0;0;16;",
			"%a2 se movimenta por baixo e rola para uma chave de joelho!;%a1 estende os quadris e %d2 está fazendo uma careta de dor. %d1 não "
					+ "aguenta mais a dor e bate!;%d2 bloqueia a tentativa e aproveita a oportunidade para entrar na meia guarda.;18;2;10;8;Joelho;1;1;0;0;0;0;16;",
			"%a1 isola um braço em uma tentativa de kimura! ;%a2 fecha as mãos e gira o braço direito de %d2! Ótimo movimento! %d2 não tem "
					+ "escolha a não ser a bater.;%d2 bloqueia a tentativa e usa a oportunidade para passar a guarda de %a2.;14;1;10;8;Kimura;1;1;0;0;0;0;16;",
			"%a1 isola um braço em uma tentativa de kimura! ;%a2 fecha as mãos e gira o braço esquerdo de %d2! Ótima movimentação! %d2 não "
					+ "tem escolha a não ser bater.;%d2 bloqueia o golpe e usa a oportunidade para passar a guarda de %a2.;13;1;10;8;Kimura;1;1;0;0;0;0;16;",
			"%a2 joga as pernas para cima em uma tentativa de triângulo!;Ele trava! Ele trava em uma chave de braço super encaixada que força "
					+ "%d2 a bater em vez de quebrar o braço!;%d1 percebe o perigo e se levanta para evite o ataque.;14;1;11;14;Chave de braço triangular;1;1;0;0;0;0;3;",
			"%a2 joga as pernas para cima em uma tentativa de triângulo!;Ele trava! Ele trava em uma chave de braço que força %d2 a bater em "
					+ "vez de quebrar o braço!;%d1 percebe o perigo e se levanta para evite o ataque.;13;1;11;14;Chave de braço triangular;1;1;0;0;0;0;3;",
			"%a2 tenta um triângulo por baixo! %d1 escorrega. %a2 rapidamente vira o quadril e muda para a chave de braço! Ele está fazendo"
					+ " muita força!.;%d1 tenta rolar, mas é está muito encaixado e ele bate! Técnica incrível !;%d1 escapa e recua para evitar o"
					+ " perigo.;14;2;11;14;Triângulo para chave de braço;2;1;0;0;0;0;3;",
			"%a2 tenta um triângulo por baixo! %d1 escorrega. %a2 rapidamente vira o quadril e muda para a chave de braço! Ele está apostando"
					+ " tudo nessa tentativa.;%d1 tenta rolar, mas é está muito apertado e ele bate! Técnica incrível !;%d1 escapa e recua para evitar"
					+ " o perigo.;13;2;11;14;Triângulo para chave de braço;2;1;0;0;0;0;3;",
			"%a1 consegue um braço e tenta aplicar uma chave de braço. %d2 gira, mas %a1 estava pronto para isso e rapidamente muda para um "
					+ "triângulo! ele tenta fugir antes de ser forçado a bater.;%d2 é muito bom e conseguiu recuar para fora do perigo.;0;1;11;14;Armbar"
					+ " no Triângulo;2;1;0;0;0;0;3;",
			"%a1 passa por cima de um braço e começa a girar! Manobra interessante.;%a2 começa a girar o cotovelo de %d2 cada vez mais fundo."
					+ " %d1 grita de dor e bate até o árbitro separar os lutadores! A luta acabou, simples assim!;%d2 puxa o braço para fora do perigo.;14;3;8;10;Bloqueio de ombro;1;1;0;0;0;0;0;",
			"%a1 passa por cima de um braço e começa a girar! Movimento interessante.;%a2 começa a girar o cotovelo de %d2 cada vez mais fundo."
					+ " %d1 grita de dor e bate até o árbitro separar os lutadores! A luta acabou, simples assim!;%d2 consegue puxar o braço para fora do perigo.;13;3;8;10;omoplata ;1;1;0;0;0;0;0;",
			"%a2 muda para a guarda fechada pouco antes de tentar encaixar um triângulo!;%d2 bate com sua força restante antes de apagar."
					+ " Movimento perfeito de %a2.;%d2 luta e sua cabeça fica vermelha com o estrangulamento, mas ele consegue escorregar a cabeça da"
					+ " finalização!;0;0;10;15;Triangle Choke;0;0;0;-1;0;0;0;",
			"%a2 muda para a guarda fechada pouco antes de tentar encaixar um triângulo!;%d2 bate com sua força restante antes de dormir."
					+ " Ótimomovimento %a2.;%d2 luta e sua cabeça fica vermelha com o estrangulamento, mas ele consegue para tirar a cabeça da do"
					+ " triângulo!;0;0;8;10;Triangle Choke;0;0;0;-1;0;0;0;"

	));

	public static final ArrayList<String> standUpSub1 = new ArrayList<String>(Arrays.asList(
			"Grande erro de %d1! %a2 tenta acabar com ele com um mata leão!;%d2 luta impotente, mas aquele estrangulamento "
					+ "de %a2 parece ser indefensável! Ele está fora!;%a2 não consegue fechar e %d2 consegue escapar;0;0;1;3;mata leão;1;1;0;0;1;0;0",
			"%a1 tenta finalizar com um mata-leão!;%a2 fecha o estrangulamento! %d1 está ficando vermelho! Ele bate!;%d2 "
					+ "se abaixa e empurra o oponente.;0;0;1;3 ;calço traseiro;1;1;0;0;0;0;1",
			"%a1 encaixa uma guilhotina com um braço para dentro...;Ele traz %d1 para o chão e parece bem encaixada! %d1 bate "
					+ "rapidamente antes de desmaiar!;%d1 traz %a1 para o chão e puxa sua cabeça pra fora.;0;3;10;8;guilhotina;1;1;-1;-2;0;0;10;",
			"%a1 encaixa uma guilhotina e tenta puxar para a guarda...;Está muito encaixada! %d1 não consegue escapar e bate!"
					+ ";%d1 escorrega a cabeça para fora e acaba na guarda de %a1.;0;3;15 ;10;guilhotina;1;1;-2;0;0;0;10;",
			"%a1 consegue controlar o pescoço de %d1 e tenta uma guilhotina!;%d1 tenta se livrar, mas está profundo. Ele não"
					+ " consegue escapar e tem que bater!;%d1 o sacode e evita o perigo.;0;3;1;10;Guilhotina em pé;1;1;-2;0;0;0;0;"));

	public static final ArrayList<String> openGuardSub1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta finalizar com uma chave de perna!;Acabou! %d2 não aguenta a dor e bate!;%d2 consegue rolar e "
					+ "defender.;19;0;10;7;chave de perna;1;1;0;0;0;5;0",
			"%a1 tenta finalizar com uma chave de Calcanhar!;Acabou! %d2 não aguenta a dor e bate!;%d2 consegue se defender"
					+ ".;20;0;10;7;chave de perna;1;1;0;0;0;5;0",
			"%a2 está na guarda aberta sobre %d2... ele finge um movimento e depois tenta uma chave de joelho!;%d1 grita de "
					+ "dor e bate! %ref força %a2 a quebrar a chave.;%d2 rola no chão tentando para se livrar e depois de alguns chutes "
					+ "ele escapa.;17;2;7;15;Kneebar;1;1;0;0;0;0;3;",
			"%a2 está na guarda aberta sobre %d2... ele finge um movimento e depois tenta uma chave de joelho!;%d1 grita de "
					+ "dor e bate! %ref força %a2 a soltar a finalização.;%d2 rola no chão tentando para se libertar e depois de alguns "
					+ "chutes ele escapa.;18;2;7;15;Kneebar;1;1;0;0;0;0;3;"

	));

	public static final ArrayList<String> clinch = new ArrayList<String>(Arrays.asList(
			"%a2 quer levar a luta a seu favor e tenta agarrar.;%a2 avança e segura %d2;%d2 não quer nada disso e "
					+ "empurra %a2.;0;2;1;3;Conquistar;1;1;0;0;0;12;1",
			"%a1 finge um soco e se lança sobre %d2!;Bom movimento de %a2 que agarra e empurra %d2 contra %site;%d1 é "
					+ "esperto o suficiente para evitar o jogo de clinche de %a2 e o empurra!;0;2;2;4;Clinch;1;1;0;0;0;12;1",
			"%a2 tenta algum entrar clinche para controlar a luta...;Muito bem. %a2 está no clinche com %d2.;%d2 move-se"
					+ " para trás e circula em torno de %a1.;0;2;3;7;Clinch;1;1;0;0;0;12;1",
			"%a1 se inclina para a frente e tenta agarrar %d2;%a2 mostra suas habilidades de clinche . Ambos os lutadores "
					+ "estão no clinche agora.;%d2 quer manter a distância e se esquiva.;0;2;1;2;Conquistar;1;1;0;0;0;12;1",
			"%a2 tenta agarrar;Ele coloca %d2 em um clinche e está com dois ganchos encaixados!;%d2 se move para o lado "
					+ "mantendo a luta a distância;0;0;0;0;Grappling;0;0;0;0;0;12;0;",
			"%a2 avança em busca de alguma ação;%a1 mostra algumas habilidades ao colocar seu oponente no clinche!;%d1 "
					+ "luta um pouco antes de sair da tentativa de agarrar de %a2;0;0;0;0;Grappling;0;0;0;0;0;12;0;"

	));

	public static final ArrayList<String> rearSub1 = new ArrayList<String>(Arrays.asList(
			"%a2 tenta acabar com isso com um mata leão!;%d2 está ficando azul quando o estragulamento é fechado em seu pescoço. %d1 está desmaiando e ele bate antes de dormir!;%d2 consegue rolar no chão e sair do estrangulamento;-1;-3;10;10;RNC;1;1;0;0;2;0;16",
			"%a1 isola um braço procurando uma chave de braço pelas costas...;%a2 joga a perna por cima e %d1 está com sérios problemas! %a1 estende o quadril e %d1 é forçado a bater para a chave de braço!;%d2 trava suas mãos e força seu peso em cima de %a1 até que ele possa liberar seu braço! %a2 perdeu sua posição dominante.;14;2;10;8;Arlock;1;1;0;0;0;0;10;",
			"%a1 isola um braço procurando uma chave de braço pelas costas...;%a2 joga a perna por cima e %d1 está com sérios problemas! %a1 estende o quadril e %d1 é forçado a bater para a chave de braço!;%d2 trava suas mãos e força seu peso em cima de %a1 até que ele possa liberar seu braço! %a2 perdeu sua posição dominante.;13;2;10;8;Arlock;1;1;0;0;0;0;10;",
			"%a1 desliza o braço sob o queixo de %d1 e fecha em um mata-leão!;%d1 não consegue mais se defender e tem que bater!;%d1 empurra para cima e desliza o braço de %a1 sobre o queixo.;0;1;10;0;Mata-mata-leão;1;1;-1;-1;0;0;0;",
			"%a1 desliza o braço sob o queixo de %d1 e fecha o mata-leão!;o rosto de%d1 fica completamente vermelho antes de ele bater!;%d1 puxa a mão de %a1 para baixo e afasta o perigo;0;1;10;0;Mata-leão;1;1;-1;-1;0;0;0;",
			"%a1 tenta colocar o braço sob o queixo de %d1, mas não consegue. Ele trava os braços sobre o pescoço de %d1 e tenta finalizá-lo com um estrangulamento no pescoço! ;o pescoço de%d1 está torcido em um ângulo desagradável. Ele tenta segurar, mas a dor é demais para ele. Ele bate!;%d1 defende facilmente a tentativa.;0;1;10;0;Neck Crank;1;1;-1;-1;0;0;0;",
			"%a1 joga a perna por cima do braço de %d1 deixando-o com apenas um braço para se defender da tentativa de mata-leão de %a1! ;%d1 não consegue defender com apenas um braço e bate no estrangulamento!;%d1 libera o braço e defende o estrangulamento. Ele consegue virar %a1 e acaba por cima!;0;1;10;0;Mata-Leão;1;1;-3;-3;0;0;10;"

	));

	public static final ArrayList<String> standUp = new ArrayList<String>(Arrays.asList(
			"%a2 tenta se levantar!;ele agora está de pé;%d2 não permite!",
			"ele não quer continuar a luta nesta posição e tenta se levantar;Ele se move rápido e agora está de pé;Ele não consegue fazer isso por causa dos movimentos de %d2."

	));

	public static final ArrayList<String> counter = new ArrayList<String>(Arrays.asList(
			"%a2 está tentando contra-atacar agora!", "%d2 falha desajeitadamente aqui e é hora de %a1 revidar!",
			"%a2 tenta obter alguma vantagem depois que seu oponente falha no movimento...",
			"%d1 fica desleixado e %a1 tenta tirar vantagem...", "Técnica mal executada. %a1 procura contra-atacar!",
			"%d2 erra uma movimento e %a1 vê uma oportunidade de contra-atacar!"));

	public static final ArrayList<String> takeDown1 = new ArrayList<String>(Arrays.asList(
			"%a2 finge um soco e vai nas penas!;%d1 não reagiu a tempo e foi jogado no chão!;%d2 faz o sprawl e fica de pé.;12;2;2;3;Queda;1"
					+ ";1;0;0;0;5;1",
			"%a2 está segurando a perna esquerda de %d1... Ele está tentando derrubá-lo.;%d1 perde o equilíbrio e cai no chão.;%d1 mostra "
					+ "grande equilíbrio enquanto empurra %a1;13;3;1;3;Queda com uma perna;1;1;0;0;0;13;1",
			"%a2 está segurando a perna direita de %d1... Ele está tentando derrubá-lo.;%d1 perde o equilíbrio e cai no chão.;%d1 mostra"
					+ " grande equilíbrio enquanto empurra %a1;14;3;1;3;Queda com uma perna;1;1;0;0;0;13;1",
			"%a2 agarra o oponente pela cintura e tenta levar a luta para o chão;Grande queda de %a1;%d2 luta... %a1 não consegue "
					+ "derrubá-lo;12;1;3;1;Queda;1;1;0;0;0;5;1",
			"%a1 tenta levar a luta para o chão com uma single leg...;%d2 não consegue ficar de pé e cai no chão;%d1 pula para trás"
					+ " e solta a perna.;12;2;2;3;Queda com uma perna;1;1;0;0;0;5;1",
			"%a1 tenta levar a luta para o chão;%d2 cai.;%d2 não sai do lugar, forçando %a2 a puxar para a guarda.;12;0;0;0;Queda;1;1;0;-"
					+ " 1;0;5;10",
			"%a1 arremessa para uma tentar uma double leg!;Ele acerta! %d1 é derrubado, mas consegue puxar %a2 para a guarda.;%d1 faz o"
					+ " sprawl e consegue se manter em pé.;12;2;7;3;Double Leg;1;1;0;0;1;6;1;",
			"%a1 tenta uma raspagem simples...;%a1 pega o tornozelo distante de %d1 e o derruba no tatame! Queda habilidosa de %a2.;%d1"
					+ " estava pronto e defende bem a tentativa de queda.;12;2;2;3;Varredura Simples;1;1;0;0;0;6;0;"));

	public static final ArrayList<String> groundKO = new ArrayList<String>(Arrays.asList(
			"Acabou! O nocaute brutal de %a1 deixou %d2 esparramando no chão!",
			"%a1 apaga as luzes de %d2! Que nocaute incrível de %a2!",
			"Aquele impacto brutal deixou %d2 morto no chão! O córner de %a1 veio parabenizá-lo pelo nocaute!"));

	public static final ArrayList<String> standingKO = new ArrayList<String>(Arrays.asList(
			"%d2 caiu no chão com força! Aquele golpe esmagador de %a1 deixou %d2 inconsciente! Que finalização de %a1!",
			"%d2 caiu no chão como uma boneca de pano! Aquele golpe cirúrgico de %a1 deixou %d2 inconsciente!",
			"%d2 está fora! %d2 está fora! %a1 encerrou esta luta no estilo rolo esmagador!",
			"%d2 cai! Ele está inconsciente! Aquele nocaute fenomenal colocou o resto da divisão de %a1 em alerta!",
			"Aquele impacto brutal deixou %d2 estendido no chão! O córner de %a1 chega para parabenizá-lo!",
			"Oh! %d2 caiu ! %a1 odeixou atordoado! Os médicos chegaram! %a1 realmente queria vencer esta luta e fez isso de uma maneira impressionante.",
			"%a1 acertou o nocaute que queria! %d2 caiu! %d2 foi absolutamente destruído aqui! Uma grande vitória para %a1!",
			"%d2 caiu no chão como se tivesse sido atingido por um taco de beisebol! %a1 nocauteou %d2 de uma forma impressionante!",
			"%a1 apaga as luzes para %d2! Que bomba! Que nocaute!", "%d2 caiu como se tivesse levado um tiro! Acabou!",
			"O poder assustador de %a1 deixou %d2 dormindo pacificamente no chão!",
			"%d2 cai no chão e %a2 avança para finalizá-lo. O árbitro pula e interrompe a luta!"

	));

	public static final ArrayList<String> misc = new ArrayList<String>(Arrays.asList("A luta vai para os juízes.",
			"Juiz:", "Vencedor é", "Decisão unânime", "Decisão dividida", "Decisão da maioria", "Empate da maioria",
			"Empate", "por", "entre", "e", "Socos", "Chutes", "Quedas", "Golpes do Clinche", "Finalizações",
			"Ground and Pound", "Estatisticas", "Dano causado", "Tempo no chão", "Testa", "Olho esquerdo",
			"Olho direito", "Bochecha esquerda", "Bochecha direita", "Nariz", "Boca", "Queixo", "Tronco", "Costelas",
			"Abdômen", "Voltar", "Braço esquerdo", "Braço direito", "Coxa esquerda", "Coxa direita", "Joelho esquerdo",
			"Joelho direito", "Pé esquerdo", "Pé direito", "KO", "TKO", "Finalização", "Interrupção Médica", "No contest",
			"Desqualificação", "Tempo esgotado", "Cartel", "Tentativas de Clinche", "Dano no Clinche", "Dano no chão",
			"Dano médio", "causou", "Recebido", "Dano", "Corte", "Interrupção do médico", "O árbitro da luta é %ref.",
			"Show de horrores", "Injusto", "Incompatibilidade", "Justo", "Grande partida", "Muito Antecipado",
			"Jogo dos Sonhos", "O evento acontece em %venue", "Comparecimento", "Compras PPV",
			"Excitação do cartão preliminar", "Emoção do cartão principal", "Emoção do evento principal e co-principal",
			"Qualidade geral do evento", "Lutas realizadas", "SW", "HW", "LHW", "MM", "WW", "LV", "FW", "BW", "Ataque",
			"(T)KOs", "Lesões", "Decisões", "Desqualificação", "Duração média", "Árbitro mais usado",
			"Organização mais usada", "Duração total", "Qualquer organização", "Desconhecido",
			"%a1 quebrou o recorde de ", "maior dano causado em uma luta", "maior dano causado por um único ataque",
			"KO mais rápido", "finalização mais rápida", "Redondo", "%a1 lutou %d1 %param1 vezes.",
			"Ele ganhou %param2 deles.", "Esta é a primeira vez que eles se encontram dentro do %site",
			"Ele perdeu %param2 deles.", "Jogou de Toalha", "pontapé na virilha", "olho machucado", "cabeçada",
			"estrangular", "%a1 defende o título de %param1!", "%a1 ganha o título de %param1!",
			"Os lutadores vão lutar em um round de desempate.",
			"%a1 ganha %param1 pontos de classificação após a luta.",
			"%a1 perde %param1 pontos de classificação após a luta.",
			"%a1 e %d1 tiveram hoje a melhor luta desta organização!",
			"%a1 e %d1 tiveram hoje a pior luta desta organização!", "%a1 vem com %param1 vitórias consecutivas.",
			"%a1 vem com uma sequência de derrotas de %param1.", "Muito chato", "Chato", "Média", "Promissor",
			"Excitante"

	));

	public static final ArrayList<String> tkoRef = new ArrayList<String>(Arrays.asList(
			"%ref já viu o suficiente! A luta acabou! %d2 não estava se defendendo de forma inteligente!",
			"O árbitro puxa %a1! %d2 parece confuso e um pouco atordoado quando o sino soa para o fim da luta.",
			"%ref está pedindo a %d2 para se defender! %ref pula entre os lutadores e interrompe os socos de %d2."));

	public static final ArrayList<String> faceCut0 = new ArrayList<String>(
			Arrays.asList("%d2 tem um pequeno corte em %location;Pequeno corte %location",
					"Há uma pequena laceração no %location de %d1;Pequeno corte %location"));

	public static final ArrayList<String> faceCut1 = new ArrayList<String>(
			Arrays.asList("Corte desagradável na %location de %d1;Corte desagradável na %location"));

	public static final ArrayList<String> faceInjuries0 = new ArrayList<String>(
			Arrays.asList("%d2's %location está começando a inchar;%location inchando",
					"A %localização de %d2 está machucada após o castigo que ele recebeu!;%localização machucada"));

	public static final ArrayList<String> faceInjuries1 = new ArrayList<String>(Arrays.asList(
			"%d2 não consegue ver nada com esse olho esquerdo inchado.;Olho inchado",
			"%d2 não consegue ver nada com esse olho direito inchado.;Olho inchado",
			"%d2 está fora! Ele tem um osso orbital quebrado!;Osso orbital quebrado",
			"%d2 está fora! Ele está com a maçã do rosto quebrada!;Lesão no rosto",
			"%d1 não pode continuar lutando. %ref não permite que ele continue lutando com o olho direito inchado!;Olho inchado",
			"%d1 não pode continuar lutando. %ref não permite que ele continue lutando com o olho esquerdo inchado!;Olho inchado"));

	public static final ArrayList<String> bodyInjuries0 = new ArrayList<String>(
			Arrays.asList("Soco poderoso no corpo de %d2! Ele está sentindo a costela!;Lado contundido",
					"Duro golpe na linha de cintura de %d2, ele parece estar sentindo;Lado contundido",
					"As costelas de %d2 estão sendo marteladas, elas parecem machudadas!;Costelas marteladas"));

	public static final ArrayList<String> bodyInjuries1 = new ArrayList<String>(Arrays.asList(
			"%d1 está com uma costela quebrada. Ele não pode continuar lutando.;Costela quebrada",
			"%d1 pode ter uma costela quebrada. É doloroso vê-lo perder desta forma.;Costelas quebradas",
			"%d1 está se segurando, ele parece estar com uma dor terrível, ele quebrou uma costela;Costelas quebradas"));

	public static final ArrayList<String> armInjuries1 = new ArrayList<String>(Arrays.asList(
			"%d1 braço [SIDE] foi hiper-estendido tanto que parece deslocado, a luta acabou;Lesão no braço",
			"Essa é uma Hiperextensão articular que você não quer, %d1 quebrou o braço [SIDE], essa luta acabou;Braço quebrado",
			"Ele o atingiu com tanta força que %d1 quebrou a mão [SIDE];Mão quebrada",
			"Parece que %d1 quebrou o pulso [SIDE] com aquele bloqueio;Punho quebrado"));

	public static final ArrayList<String> legInjuries1 = new ArrayList<String>(Arrays.asList(
			"A perna [SIDE] de %d1 foi tão judiada que ele não consegue ficar de pé, a luta acabou;Lesão na perna",
			"Hiperextensão desagradável da articulação na perna [SIDE] de %d1, ele não pode lutar;Lesão na perna",
			"A rótula de %d1 [SIDE] acabou de estourar, ele não pode continuar lutando;Lesão na perna",
			"Defesa de perna ruim, %d1 quebrou o tornozelo [SIDE] com essa defesa, essa luta acabou;Lesão na perna"));

	public static final ArrayList<String> armInjuries0 = new ArrayList<String>(
			Arrays.asList("%d2 hiperestendeu seu braço [SIDE];braço hiperestendeu",
					"O braço [SIDE] de %d2 está sendo torcido, parece estar ferido;braço esquerdo contundido"));

	public static final ArrayList<String> legInjuries0 = new ArrayList<String>(
			Arrays.asList("%d2 hiperestendeu a perna [SIDE];perna [SIDE] hiperestendeu"));

	public static final ArrayList<String> sideMountSub1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta uma kimura;Muito bem! %d2 deve bater!;%d2 gira e consegue defender.;13;0;10;7;kimura;1;1;0;0;0;13;13",
			"%a1 vai para uma americana!;Ele trava! %d1 é forçado a bater!;%d2 se liberta.;13;0;10;7;Americana;1;1;0;0;0;0;0;",
			"%a1 vai para uma americana!;Ele trava! %d1 é forçado a bater!;%d2 consegue se defender.;14;0;10;7;Americana;1;1;0;0;0;0;0;",
			"%a1 isola o braço e o pescoço de %d1 procurando um triângulo de braço;%a2 o fecha e circula em direção à cabeça de %d2."
					+ " Está bem encaixado e %d1 é forçado a bater!;%d1 é capaz de aliviar a pressão em seu pescoço e escapar.;0;0;10;7;Arm "
					+ "Triangle;1;1;0;0;0;0;0;",
			"%a1 engancha a perna esquerda de %d2 e se senta para trás para uma chave de joelho!;%a2 estende seus quadris e parece que "
					+ "está pegando. %d1 bate! Movimento inteligente, %d1 poderia ter sido gravemente ferido por aquela chave de joelho.;%d1"
					+ " consegue chutar %a2, sai e sobe por cima!;17;2;8;10;Joelhada;1;1;0;0;0;0;9;",
			"%a1 engancha a perna direita de %d2 e se senta para trás para uma chave de joelho!;%a2 estende seus quadris e ta bem encaixada. "
					+ "%d1 bate! Movimento inteligente, %d1 poderia ter sido gravemente ferido por aquela chave de joelho.;%d1 consegue chutar %a2 "
					+ "sai e sobe por cima!;18;2;8;10;Joelhada;1;1;0;0;0;0;9;",
			"%a2 se desloca para a posição norte-sul e tenta finalizar com uma estrangulamento!;%d2 apagou! %ref manda soltar a finalização "
					+ "e %d1 está apagado no chão! Movimento incrível de %a1.;%d2 empurra %a1 para frente contra suas costas e sai do"
					+ " estrangulamento!;0;0;0;0;Estrangulamento Norte Sul;0;0;0;0;0;0;10;",
			"%a1 isola o braço direito de %d1 procurando um armlock... ;%d1 tenta segurar o próprio braço, mas %a1 quebra a pegada e"
					+ " estende "
					+ "o braço pra finalização!;%d1 consegue sentar e puxar o braço fora de perigo! %a1 perdeu sua posição dominante."
					+ ";14;1;15;8;armlock;1;1;-1;1;0;0;9;",
			"%a1 isola o braço esquerdo de %d1 procurando uma chave de braço... ;%d1 tenta segurar o próprio braço, mas %a1 quebra a"
					+ " pegada e "
					+ "estende o braço para a finalização!;%d1 consegue sentar e puxar o braço fora de perigo! %a1 perdeu sua posição dominante."
					+ ";13;1;15;8;armlock;1;1;-1;1;0;0;9;",
			"%d1 tenta se virar e sair correndo. %a1 pega as costas e trava um mata-leão!;%d1 está tentando encontrar uma saída, mas está "
					+ "muito"
					+ " apertado! Ele é forçado a bater antes de dormir!;Ele não consegue travar. %d1 gira e se levanta.;0;1;9;3;mata-leão;1;1;"
					+ "-2;0;0;0;1;",
			"%d1 tenta se levantar. %a1 cronometrou perfeitamente e tenta uma guilhotina!;%d1 não consegue encontrar uma saída! Seu rosto"
					+ " está "
					+ "ficando roxo e ele bate antes de dormir!;%d1 escorrega sua cabeça para fora e consegue ganhar o controle por "
					+ "cima.;0;1;15;8;guilhotina;1;1;-2;0;0;0;9;"));

	public static final ArrayList<String> fullMountSub1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta finalizar a luta com uma chave de braço por cima;A dor obriga %d2 a bater! Acabou!;%d2 é esperto o suficiente para evitar a tentativa de finalização;13;0;10;8;chave de braço;1;1;0;0;0;0;0",
			"%a1 tenta finalizar a luta com uma chave de braço por cima;A dor obriga %d2 a bater! Acabou!;%d2 é esperto o suficiente para evitar a tentativa de finalização;14;0;10;8;chave de braço;1;1;0;0;0;0;0",
			"%a2 segura o braço esquerdo de %d1 e tenta uma kimura;O braço %d2 está dobrado em um ângulo terrível! %d1 bate repetidamente;%d1 segura o próprio braço e luta até se libertar;13;0;10;8 ;kimura;1;1;0;0;0;0;0",
			"%a2 segura o braço direito de %d1 e tenta uma kimura;O braço %d2 está dobrado em um ângulo terrível! %d1 bate repetidamente;%d1 segura o próprio braço e luta até se libertar;14;0;10;8 ;kimura;1;1;0;0;0;0;0",
			"%a1 isola o braço e o pescoço de %d1 procurando um triângulo de braço;%a2 o fecha e circula em direção à cabeça de %d2. Está muito encaixado e %d1 é forçado a bater!;%d1 é capaz de aliviar a pressão em seu pescoço e escapar da finalização.;0;0;10;8;Arm Triangle;1;1;0;0;0;0;0;",
			"%a1 senta-se no alto do peito de %d1 e puxa a perna por baixo da cabeça de %d2. Aí está a tentativa do triângulo!;%d1 tenta rolar, mas %a1 está muito à frente dele e já tem o triângulo travado. %d1 bate!;%d2 tenta rolar. Ele é muito rápido para %a1 e consegue escapar! Essa foi uma jogada arriscada de %a2 e custou a ele a posição.;0;0;10;8;Triângulo do Monte;1;1;0;0;0;0;10;",
			"%a2 finge alguns socos e depois de uma breve luta ele pega o braço de %d1 e tenta uma chave de braço!;%a2 lança alguns golpes no rosto de %d1 e depois se lança para trás com toda a força! %d2 bate com um sorriso dolorido.;%d2 segura a própria mão e quebra o a tentativa de finalização de %a2. Ele rola sobre si mesmo e se lança sobre %a1.;14;0;0;0;Arlock;0;0;0;0;1;0;14;",
			"%a2 finge alguns socos e depois de uma breve luta ele pega o braço de %d1 e tenta uma chave de braço!;%a2 desfere alguns golpes no rosto de %d1 e depois se lança para trás com toda a força! %d2 da os tres tapinhas.;%d2 segura sua própria mão e com pura força ele quebra a finalização de %a2. Ele rola sobre si mesmo e lança %a1.;13;0;0;0;Armlock;0;0;0;0;1;0;14;",
			"%a2 tenta uma chave de braço!;%d1 bate após uma chave de braço!;%d1 escapa da chave e empurra %a1, que rola sobre as costas e fica em pé.;13;0;0;0;Armlock;0;0;0;0;0;0;2;",
			"%a2 tenta uma chave de braço!;%d1 bate após uma chave de braço!;%d1 saí da chave e empurra %a1, que rola sobre as costas e fica em pé.;14;0;0;0;Armlock;0;0;0;0;0;0;2;",
			"%a1 respira fundo enquanto passa o braço sobre %d1 ombro e empurra seu braço [SIDE] contra o chão!;%a2 mostra uma careta de dor e desiste da luta após uma americana perfeita!;%d1 quebra aquela americana tentativa!;14;1;13;10;Americana;0;0;0;0;0;0;0;",
			"%a1 respira fundo enquanto passa o braço sobre %d1 ombro e empurra seu braço [SIDE] contra o tapete!;%a2 mostra uma careta de dor e bate repetidamente após uma americana perfeita!;%d1 saí dessa tentativa deamericana !;13;1;13;10;Americana;0;0;0;0;0;0;0;",
			"%a2 de repente segura o braço de %d1 e tenta um armlock!;%d2 quase não viu o que estava acontecendo antes do de bater!;%d2 consegue sair da chave e agora está na guarda fechada sobre %a1!;13;0;0;0;Armlock;1;1;0;0;0;0;10;",
			"%a2 de repente segura o braço de %d1 e tenta um armlock!;%d2 quase não viu o que estava acontecendo antes de dar os três tapinhas!;%d2 consegue quebrar a chave e agora está na guarda fechada sobre %a1!;14;0;0;0;Armlock;1;1;0;0;0;0;10;",
			"%a1 joga a perna e rola em um armlock!;Isso é mais do que %d2 pode suportar! Seu braço está estendido e ele bate antes de se machucar.;%d2 se defende bem da chave mostrando algumas de suas habilidades...;14;0;10;15;Armlock;1;1;0;1;0;0;0;",
			"%a1 joga a perna e rola em um armlock!;Isso é mais do que %d2 pode suportar! Seu braço está estendido e ele bate antes de se machucar.;%d2 se defende bem da chave mostrando algumas de suas habilidades...;13;0;10;15;Armlock;1;1;0;1;0;0;0;"));

	public static final ArrayList<String> lnp = new ArrayList<String>(Arrays.asList(
			"%a2 não mostra muita ação no chão... Parece feliz em deixar o tempo passar.;%a1 está amarrando a luta no chão;%d2 não gosta da ideia de ficar apenas parado no chão;0;0;10;8;LnP;0;0;0;0;0;0;0",
			"%a1 aproveita a situação para respirar.;%a2 respira fundo enquanto está no chão;%a1 luta para não dar chance ao oponente de se recuperar;0;0;10;7;LnP;0;0;0;0;0;0;0",
			"%a1 parece contente em apenas manter esta posição.;%a2 está aproveitando esta oportunidade para descansar.;%d2 está ficando frustrado aqui.;0;0;10;7;LnP;0;0;0;0;0;0;0;"));

	public static final ArrayList<String> fancyPunch1 = new ArrayList<String>(Arrays.asList(
			"%a2 avança e tenta um superman punch!;Bang! Isso esmaga o rosto de %d2 e talvez suas esperanças de vencer esta luta também!;%d2 desvia apenas se movendo para o lado. %a1 passou no vazio e %d1 da um sorriso!;5;2;1;4;Soco do Superman;1;1;1;2;4;0;0",
			"%a1 de repente gira...;e acerta com um belo soco rodado bem no queixo de %d2!;%d1 estava ciente desse movimento e o bloqueia com confiança.;8;3;9;1;Girando o punho para trás ;1;1;0;0;5;0;0",
			"%a1 colocou um grande poder por trás daquele superman punch!;Isso é simplesmente incrível! Esse soco atinge o rosto de %d1 como uma bola de demolição!;Esse passou raspando quando %d1 dá um passo para trás!;6;2;2;1;Soco do Superman ;1;1;0;1;5;0;0",
			"%a1 gira de repente...;... manda uma cotovelada rodada no queixo de %d2!;%d1 se abaixa e passa por cima de sua cabeça.;8;3;1;2;Girando o punho para trás;1;1;0;1;4;0;0"));

	public static final ArrayList<String> refAware = new ArrayList<String>(
			Arrays.asList("%ref viu isso!", "%ref viu!"));

	public static final ArrayList<String> headbutt = new ArrayList<String>(Arrays
			.asList("%a2 está se movendo no chão...;Ai! Isso foi uma cabeçada! Ele fez isso intencionalmente?;%d2 tenta"
					+ " contra-atacar os movimentos de %a2 no chão.;0;0;10;10;cabeçada;1;1;3;3;3;0;0"));

	public static final ArrayList<String> groundEyePoke = new ArrayList<String>(Arrays.asList(
			"%a2 trabalha no chão com os dedos sobre o rosto de %d2;Ele parece ter encontrado o "
					+ "olho! Que movimento sem classe!;%d2 balança a cabeça e continua lutando no chão.;2;0;0;0;Coçar o olho;1;1;0;0;0;0;0",
			"%a2 trabalha no chão com os dedos sobre o rosto de %d2;Ele parece ter encontrado o "
					+ "olho! Que movimento sujo!;%d2 balança a cabeça e continua lutando no chão.;3;0;0;0;Coçar o olho;1;1;0;0;0;0;0"));

	public static final ArrayList<String> standingEyePoke = new ArrayList<String>(Arrays.asList(
			"%a2 lança um soco certeiro!;Isso quase não atinge o rosto de %d2, mas parece que um dedo espetou seu olho! O árbitro vê isso?;%d2 se esquiva.;2;1;1;2;Espetada no olho ;1;1;0;0;0;0;0",
			"%a2 lança um jab forte!;Isso quase não atinge o rosto de %d2, mas parece que um dedo cutucou seu olho! O árbitro vê isso?;%d2 se esquiva.;3;1;1;2;Espetada ;1;1;0;0;0;0;0"));

	public static final ArrayList<String> restOnGround = new ArrayList<String>(
			Arrays.asList("%a1 leva alguns segundos para recuperar o fôlego..."));

	public static final ArrayList<String> rest = new ArrayList<String>(
			Arrays.asList("%a1 demora alguns segundos para recuperar o fôlego...",
					"%a2 dá um passo para trás, afastando-se de %d1. Ele parece estar esfriando um pouco a luta.",
					"%a2 empurra %d1 e se afasta dele. Ele parece estar recuperando o fôlego."));

	public static final ArrayList<String> groinKnee = new ArrayList<String>(Arrays.asList(
			"%a2 tenta uma joelhada...;Ai! Isso parece ter acertado a virilha de %d1! Isso não foi intencional?;%d2 bloqueia aquele joelho;11;1;3;3;Joelho na virilha;1;1;0;0;0;0;0",
			"%a1 lança uma joelhada furiosa!;Acertou! Ela acerta claramente a virilha de %d2!;%d1 bloqueia e luta enquanto tenta tomar a iniciativa.;11;1;3;3;Joelhada na virilha;1;1;0;0;0;0;0"));

	public static final ArrayList<String> slam = new ArrayList<String>(Arrays.asList(
			"%a2 levanta seu oponente do chão e tenta derrubar ele com tudo!;Joga %d1 no chão! Slam brilhante!;%d2 mostra boas habilidades de sprawl e permanece de pé.;12;1;3;1;Batida;1;1;0;2;1;5;0",
			"%a2 levanta seu oponente do chão!;Slam lateral!;%d2 luta e mostra boas habilidades de sprawl ;10;0;3;1;Batida;1;1;0;0;0;13;1",
			"%a2 agarra %d1;Ele o levanta e o joga com força no chão!;%d2 o sacode.;10;1;0;3;Slam;1;1;0;2;1;5;1",
			"%a2 levanta %d1 do chão;...grande pancada na queda!;...antes de colocá-lo de volta no chão.;12;1;3;1;Batida;1;1;0;2;1;5;0",
			"Os lutadores agarrados brevemente...;%d2 é levantado e jogado com força no chão enquanto %a2 acerta um grande slam!;%d2 escapa dos ganchos de %a2.;12;1;3;1;Slam;1;1;0;2;1;5;0",
			"%a2 consegue agarrar seu oponente;e avança, boa queda!;mas não consegue acertar.;0;2;3;1;Spike;1;1;1;0;2;5;0",
			"%a1 vai para o suplex...;Uau, incrível!;Sua tentativa não leva a lugar nenhum.;12;2;4;9;Suplex;1;1;0;2;1;5;0",
			"%d2 está agarrado.;Má ideia! %a1 levanta-o e lança-o para o chão!;Ele procura uma abertura para atacar.;10;1;4;3;Slam;1;1;0;2;1;5;0",
			"%a2 está tentando levantar %d2!;Brilhante suplex!;%d2 se movimenta para fora e evita a queda.;10;1;9;3;Batida;1;1;0;1;0;13;1",
			"%a1 está preparando um suplex;Ele quase derruba %d2 de cabeça!;Não consegue manter, %d2 se solta.;9;2;4;9;Arremesso;1;1;-1;2;2;5 ;0",
			"%a1 agarra %d2;%d1 é jogado no chão.;%d2 solta a pegada de %a2.;10;2;4;9;Arremesso;1;1;0;1;1;5;0",
			"%a2 prepara um slam;%d1 voa pelo ar!;Ele se atrapalha e cai!;12;0;0;0;Arremesso;1;1;0;1;1;5;9"));

	public static final ArrayList<String> supplex = new ArrayList<String>(Arrays.asList(
			"%a2 levanta seu oponente do chão!;Que suplex incrível! Que incrível!;%d2 faz uma defesa consegue tocar o "
					+ "chão novamente.;0;2;3;1;Supplex;1;1;-3;4 ;4;13;0",
			"%a1 coloca os braços em volta do oponente e tenta levantá-lo...;%a1 torce seu corpo e consegue um lindo suplex"
					+ " !;%d1 tem quadris fortes e não se deixa ser arremessado. ;12;1;9;1;Suplex Barriga a Barriga;1;1;-3;4;4;13;0;",
			"%a1 pega %d1 bem e procura um grande suplex...;%a1 o joga no ar e o acerta lateralmente! Isso não deve ser bom "
					+ "nas suas costas.;%d1 defende o suplex e permanece de pé.;12;1;9;1;Side Slam;1;1;-1;2;1;13;0;",
			"%a1 consegue uma boa pegada em %d1 e procura um grande suplex...;%a1 impulsiona %d1 no ar e o derruba de cabeça! "
					+ "Arremesso desagradável de %a1!;%d1 defende o suplex e permanece em seus pés.;0;3;9;1;Batida Lateral;1;1;-2;3;5;13;0;"));

	public static final ArrayList<String> supplex1 = new ArrayList<String>(Arrays.asList(
			"%a2 agarra %d1 pelos quadris!;Suplex incrível! %d2 deve estar se perguntando se ele está lutando na"
					+ " WWE!;%d2 faz o sprawl e permanece de pé.;0;1;3;9;Supplex;1;1;0;2;2;7;3",
			"%a2 tenta derrubar...;Que suplex incrível aqui! %a2 apenas nos mostra sua força lançando %d2 sobre sua "
					+ "própria cabeça!;%d2 faz o sprawl e permanece em pé.;0;1;1;3;Suplex;1;1;0;2;2;7;3",
			"%a1 se joga para e vira o canto ganhando o controle da cintura de %d1 atrás dele. Ele olha para derruba-lo..."
					+ " ;%a1 o levanta no ar e arqueia suas costas batendo em sua cabeça! incrível suplex!;%d1 acerta uma defensa e quebra a pegada de %a1 sobre ele.;0;3;9;1;Suplex alemão;1;1;-2;3;5;17;0;",
			"%a1 passa por cima dos braços de %d1 e tenta derrubá-lo.;%a1 dá um torque em seu corpo e o joga contra o chão "
					+ "com uma chamativa queda!;%d1 libera seus braços e permanece de pé.;12;3;9;1;Arremesso de Overhook;1;1;-2;3;5;13;0;"));

	public static final ArrayList<String> soccerKicks1 = new ArrayList<String>(Arrays.asList(
			"%a2 tenta um chute de futebol na cabeça de %d1;Golpe terrível! %d2 está com problemas!;%d1 rola no "
					+ "chão e foge do chute.;0;-1;15;12;Chute de futebol;1;1;0;2;4;0;0",
			"%a1 segura a cabeça de %d2 no chão e prepara um chute...;Esse chute bate forte na cabeça de %d2.;%d1"
					+ " bloqueia o chute, mas ele tem que fazer algo logo ou vai se ferrar!;0;-1 ;12;15;Chute de Futebol;1;1;0;2;4;0;0"));

	public static final ArrayList<String> stomps1 = new ArrayList<String>(Arrays.asList(
			"%a2 levanta a perna...!;E pisa na cara de %d2!;%d2 se cobre e bloqueia a pisada.;6;0;15;12;Batida;1;1;0;3;5;0;0"));

	public static final ArrayList<String> standingToGround1 = new ArrayList<String>(Arrays.asList(
			"%a2 lança um chute na coxa de %d2;Fez um barulho alto!;%d2 defende o chute!;15;-2;15;12;Chute;1;1;0;-5;-10;0;0"));

	public static final ArrayList<String> moveToGround = new ArrayList<String>(Arrays.asList(
			"%a2 decide ir atrás do oponente e pula para dentro da guarda de %d2.;%d2 não previu isso! %a1 está na guarda aberta sobre %d2 agora.;%d2 tenta revidar com os pés e %a2 apenas precisa de outro plano agora.;0;1;12;12;mover para o chão;1;1;0;0;0;5;0",
			"%a1 opta por ir atrás de seu oponente e pula para dentro da guarda de %d2.;%d2 não previu isso. %a2 está na guarda aberta sobre %d2 agora.;%d2 revida com os pés, forçando %a2 a tentar outra coisa.;0;1;12;12;Mover para o chão;1;1;0;0;0;5;0",
			"%a1 decide pular para dentro da guarda de %d2.;%d2 não previu isso. %a2 está na guarda aberta sobre %d2 agora.;%d2 revida com os pés, forçando %a2 a tentar outra coisa.;0;1;12;15;Mover para o chão;1;1;0;0;0;5;0",
			"%a2 opta por pular para dentro da guarda de %d2.;%d2 não previu isso. %a1 está na guarda aberta sobre %d2 agora.;%d2 revida com os pés, forçando %a2 a tentar outra coisa.;0;1;12;12;Mover para o chão;1;1;0;0;0;5;0",
			"%a2 esta toreando %d2!;Ele cai de lado sobre um surpreso %d1.;%d2 revida e evita a passagem de guarda.;0;2;15;12;Toreando;1;1;0;0;0;13;0"));
	//
	public static final ArrayList<String> strikesFromGuard1 = new ArrayList<String>(Arrays.asList(
			"%a2 lança alguns socos fracos;Esses socos estão acertando as costelas de %d2.;%d2 os bloqueia efetivamente.;10;1;10;8;Golpes da guarda;3;2;0;-2;-2;0;0",
			"Respiração funda de %a1 que tenta dar socos nas costelas de %d2.;Acerta %d2 que se move no chão para se proteger;%d2 bloqueia esses socos;10;1;10;8;Golpes da guarda;1;1;0;0;-2;0;0"));

	public static final ArrayList<String> strikesFromGuard2 = new ArrayList<String>(Arrays.asList(
			"%a2 mede a resiliência das costelas de %d2 com alguns socos fortes da guarda.;Esses golpes estão deixando problemas no corpo de %d2.;%d2 bloqueia os golpes enquanto trabalha no chão.;10;0;8;10;Golpes da guarda;2;2;0;0;0;0;0",
			"%a1 dá alguns socos no rosto de %d2 da guarda.;Esses socos com certeza são irritantes porque %d2 tenta cobrir o rosto,;%d1 usa a cabeça para cobrir os socos e pressiona o seucrânio para frente.;4;0;10;15;Golpes da guarda;3;2;0;0;0;0;0"));

	public static final ArrayList<String> groundToStanding1 = new ArrayList<String>(Arrays.asList(
			"%a2 tenta acertar %d1 com um chute no joelho do chão.;Belo chute. %d2 dá um passo para trás tentando encontrar uma maneira de usar sua vantagem agora.;%d2 desvia disso;17;2;11;14;Chute do chão;1;1;0;-2;-10;0;0",
			"%a1 lança um chute para cima destinado à cabeça de %d1...;Ele acerta a cabeça de %d1, jogando-a para trás devido ao impacto!;%d2 se inclina para desviar do chute.;0;0;0;0;Chute para cima;1;1;0;-2;-10;0;0;",
			"%a1 chuta as pernas de baixo para cima tentando manter %d1 longe.;%d1 leva um chute no corpo.;Nenhum dano causado por esses chutes.;11;0;0;0;Chutes;4;1;-10;- 7;-5;0;0;"));

	public static final ArrayList<String> restInClinch = new ArrayList<String>(
			Arrays.asList("%a2 faz uma pausa para respirar enquanto segura %d1.",
					"%a1 empurra ligeiramente %d2 para o %HoldSite e tenta acalmar a ação."));

	public static final ArrayList<String> noAction = new ArrayList<String>(
			Arrays.asList("Ambos os lutadores circulam em torno do centro do %site.",
					"%a2 estuda seu oponente procurando uma brecha em sua defesa.",
					"%a1 finge um soco e mostra algum trabalho de pés movendo-se para o lado.",
					"%a2 e %d2 circulam ao redor do centro do %site.", "Os lutadores se estudam no centro do %site.",
					"Esses dois lutadores estão demonstrando muito respeito um pelo outro.",
					"%a1 está fazendo sua melhor impressão de Floyd Mayweather ao não se envolver.",
					"%a2 se move para trás e %d1 está perguntando se ele veio hoje para lutar ou correr."));

	public static final ArrayList<String> allowStand = new ArrayList<String>(Arrays.asList(
			"%a1 cria espaço e permite que %d1 se levante.", "%a2 se move para trás e gesticula para %d1 se levantar.",
			"%a1 dá um passo para trás e permite que %d2 se levante novamente."));

	public static final ArrayList<String> pullGuard = new ArrayList<String>(Arrays.asList(
			"%a2 empurra %d1 para baixo e tenta puxar a guarda;%d2 desajeitadamente cai na guarda de %a1!;%d2 se solta e %a1 cai no chão!;0;0;0;0;Puxa guarda;1;1;-5;-5;-5;10;3;",
			"%a2 está trabalhando no clinche e de repente tenta puxar para a guarda!;%a2 traz %d1 para o chão e rapidamente fecha a guarda.;%d1 avança e mantém a luta no clinche.;10;2;3;9;Puxar proteção;1;1;-5;-5;-5;10;0;",
			"%a1 tenta uma queda, mas não consegue. Em vez disso, ele decide puxar para a guarda...;%a1 o envolve bem e o puxa para a guarda.;%d1 é muito forte. Ele não permite ser levado ao chão. %a1 abandona a tentativa de puxar para guarda.;0;1;3;0;puxar guarda;1;1;-8;-9;-5;10;0;",
			"%a1 tenta puxar %d1 para a sua guarda...;consegue puxar para a guarda. ;%d1 o empurra para baixo e fica de pé.;0;0;0;0;Puxa a guarda;1;1;-6;-2;-5;10;3;"));

	public static final ArrayList<String> gnpElbows1 = new ArrayList<String>(Arrays.asList(
			"%a2 tenta abrir %d2 com alguns golpes com o cotovelo direito...;Alguns bons chutes estão acertando e %d2 está tentando bloqueá-los com as mãos...;%d2 bloqueia alguns cotovelos e agora %a1 terá que procurar outra opção aqui.;0;1;10;13;Cotovelos;4;2;2;0;0;0;0;",
			"%a2 está tentando melhorar sua posição no chão e lança algumas cotoveladas nas costelas de %d2.;%d2 está percebendo isso e seu rosto mostra a dor.;%d2 bloqueia os movimentos de %a1 e tenta reverter a situação. ;10;2;10;15;Cotovelos;2;2;0;1;0;0;0;"));

	public static final ArrayList<String> gnpElbows2 = new ArrayList<String>(Arrays.asList(
			"%a2 se posiciona para um round de ground and pound e tenta finalizar a luta com algumas "
					+ "cotoveladas precisas!;Um, dois, três! %d2 está sendo punido aqui!;%d2 tenta se cobrir e bloqueia as cotoveladas.;0;0;10;7;Cotovelos;3;3;3;1;2;0;0;",
			"%d2 tenta se mexer no chão e mostra %a1 uma espaço na guarda que usa para uma grande "
					+ "cotovelada!;Acertou! A testa de %d2 recebe uma cotovelada forte que balança sua cabeça contra o chão!;%d2 usa seus antebraços para bloquear o impacto!;1;0;7;10;Cotovelo;1;1;4;2;2;0;0;"));

	public static final ArrayList<String> gnpElbows3 = new ArrayList<String>(Arrays.asList(
			"%a2 lança uma saraivada de cotoveladas no rosto de %d2!;Essas cotoveladas podem terminar a luta em breve se %d2 não revidar!;%d1 bloqueia as cotoveladas e tenta esfriar a luta.;0;0;10;13;Cotovelos;5;3;4;2;3;0;0;",
			"%a1 ataca %d2 com uma punição bíblica na forma de cotoveladas!;%a2 não para e bate ferozmente novamente e novamente no rosto de %d2 com seus cotovelos!;%d1 bloqueia todos eles mostrando algumas ótimas habilidades de defesa aqui.;0;0;7;10;Cotovelos;6;4;4;2;4;0;0;",
			"%a2 desfere algumas cotoveladas precisas!;%d2 está sendo atingido com força e tenta escapar! Ele tem que dar as costas!;%d1 bloqueia todos eles mostrando algumas ótimas habilidades de defesa aqui.;0;0;13;10;Cotovelos ;6;4;4;2;4;7;0;"));

	public static final ArrayList<String> capitalizeStanding = new ArrayList<String>(Arrays.asList(
			"%a1 corre para capitalizar e lança uma enxurrada de socos sobre um %d1 atordoado que quase não consegue ficar de pé!;Um após o outro %a1 está punindo %d2! Uau! %ref deve fazer algo em breve!;%d2 desvia quase milagrosamente da maioria dos socos e escapa!;0;0;1;3;Socos;5;4;0;0;2;0;0;",
			"%d2 tropeça para trás cambaleando e %a1 se lança agressivamente sobre seu oponente dando alguns socos violentos!;%d2 é derrubado após alguns socos, acertando o chão com força! Ele está fora?;%d1 mostra seu instinto de sobrevivência enquanto bloqueia aqueles socos! A multidão está de pé!;0;0;1;9;Socos;3;2;0;0;3;2;0;",
			"%d1 parece abalado! %a1 vê sua oportunidade de terminar a luta e lança uma rajada agressiva de socos!;%d1 está levando uma surra brutal e cai no chão! O árbitro pode parar esta luta a qualquer momento.;%a1 não conseguiu acertar seu oponente atordoado.;0;0;1;3;Socos;5;3;0;2;2;2;0;"));

	public static final ArrayList<String> capitalizeGround = new ArrayList<String>(Arrays.asList(
			"%a2 sabe que seu oponente está grogue e começa uma chuva implacável de socos!;%d1 está tendo um pesadelo! %ref observa o momento em que ele tem que terminar isso!;%d2 bloqueia aqueles socos!;0;0;10;7;GnP;6;4;1;1;3;0;0;",
			"%a1 se posiciona e tenta finalizar isso!;%a1 ataca a cabeça de %d1 com alguns marretadas! %ref está pedindo a %d1 para se defender!;%d1 bloqueia e desvia da maioria dos socos! %a1 parece frustrado !;0;0;10;13;GnP;3;2;0;0;4;0;0;",
			"%a1 bombardeia o seu oponente tentando terminar esta luta!;%d1 está levando uma tonelada de socos! Ele precisa se defender ou o árbitro irá parar a luta.;%d1 recupera sua compostura o suficiente para evitar aqueles golpes.;0;0;10;13;GnP;6;3;0;0;3;0;0;",
			"%a1 Vê sua oportunidade de terminar esta luta no chão e ataca %d1!;%d1 está levando uma tonelada de socos! Ele precisa se defender ou o árbitro irá parar a luta.;%d1 recupera a compostura o suficiente para evitar esses golpes.;0;0;10;13;GnP;5;2;0;0;4;0;0;"));

	public static final ArrayList<String> kneesOnGroundHead = new ArrayList<String>(Arrays.asList(
			"%a1 está segurando a cabeça de %d1 e procurando por ângulos...;Ai! Que joelhada poderosa de %a1! Aquele bate no rosto de %a1 [SIDE] como um martelo!;%d1 se cobre e bloqueia uma poderosa joelhada do oponente!;5;0;10;15;Joelho;1;1;0;2;2;0;0;",
			"%a1 está segurando a cabeça de %d1 e procurando por ângulos...;Ai! Que joelhada poderosa de %a1! Aquele bate no lado [SIDE] do rosto de %a1 como um martelo!;%d1 se cobre e bloqueia uma poderosa joelhada do oponente!;4;0;10;15;Joelho;1;1;0;2;2;0;0;",
			"%a2 lança uma joelhada violenta na cabeça de %d1!;Bang! Você pode ouvir o técnico de %d1 gritando para seu lutador escapar agora!;%d2 avança e rola sobre as próprias costas! Boa jogada! %d1 se levanta!;0;0;0;0;Joelho;1;1;0;2;3;0;3;"));

	public static final ArrayList<String> kneesOnGroundSide = new ArrayList<String>(Arrays.asList(
			"%a2 segura %d1 e tenta lançar uma joelhada nas costelas!;%d2 não conseguiu defender o golpe... Uma joelhada feia nas costelas!;%d2 é rápido o suficiente para bloquear aquela joelhada!;10;0;10;7;Joelho;1;1;0;2;0;0;0;",
			"%a2 lança algumas joelhadas rápidas nas costelas de %d1!;Grande movimento de %a1! %d2 deve fazer algo agora se quiser escapar dessa posição!;%d2 move-se no chão e mantém os joelhos de %a1 afastados com os braços.;10;0;15;10;Joelhos;2;2;0;0;1;0;0;",
			"Belo movimento de %a1 que se posiciona para usar os joelhos em %d2!;Um, dois! Olha a careta de dor de %d1!;Técnica horrível! %d2 envolve uma das pernas na %a1 perna e rola no chão !Ele agora está na meia-guarda sobre seu oponente!;10;0;0;0;Joelhos;2;2;0;3;0;0;16;"));

	public static final ArrayList<String> fullMountFancySub1 = new ArrayList<String>(Arrays.asList(
			"%a1 lança alguns socos falsos e depois se vira e pega %d1 perna, rola e tenta uma chave de joelho!;%d2 tenta alguns chutes, mas %a2 coloca toda a sua força e %d1 tem que bater.;%a2 dá alguns chutes e rola até conseguir sair da chave. %a2 e %d1 se levantam. Isso foi por pouco!;18;0;0;0;Joelhada;0;0;0;0;0;0;1;",
			"%a1 senta-se no alto do peito de %d1 procurando algum tipo de finalização;%a2 traz sua canela na garganta de %d1 em uma tentativa de gogoplata! Movimento arriscado, mas parece encaixado. Ele puxa a parte de trás da cabeça de %d2 e o força a bater!;%d2 tenta rolar e %a1 perde o equilíbrio. Essa era uma posição arriscada e %a2 perde a montada. %d1 ganha controle por cima.;0;2;10;8;Montado Gogoplata;1;1;0;0;0;0;10;",
			"%a2 agarra o próprio pé e desliza por baixo do queixo de %d2 em uma tentativa de gogopata!;%a1 fecha com força! %d2 não consegue se livrar e deve bater! Movimento brilhante de %a2.;%d2 consegue se defender e usa a oportunidade de passar a guarda de %a2.;0;2;10;5;Gogoplata;1;1;0;0;0;0;16;",
			"%a2 joga a perna por cima do ombro de %d2 em uma tentativa de omoplata!;%a1 levanta os quadris e senta-se para a frente sobre o ombro esquerdo de %d2 ! %d2 não consegue rolar livremente e bate em vez de ter o ombro deslocado!;%d1 senta-se e desliza o braço para fora usando a oportunidade para obter o controle na posição de 100kg!;13;1;10;5;Omoplata;1;1;0;0;0;0;14;",
			"%a2 joga a perna por cima do ombro de %d2 em uma tentativa de omoplata!;%a1 levanta os quadris e senta-se para a frente sobre o ombro direito de %d2 ! %d2 não consegue rolar livremente e bate em vez de ter o ombro deslocado!;%d1 senta-se e desliza o braço para fora usando a oportunidade para obter o controle na posição de 100kg!;14;1;10;5;Omoplata;1;1;0;0;0;0;14;"));

	public static final ArrayList<String> sideMountFancySub1 = new ArrayList<String>(Arrays.asList(
			"%a1 tenta acertar a cabeça de seu oponente em algum tipo de estrangulamento!;%a1 fecha um triângulo de mão %d1 fica azul antes de dormir! Isso acabou!;%d2 luta e empurra seu oponente para frente. Ambos os lutadores respiram duro enquanto eles se levantam.;0;0;0;0;Anaconda sufoca;1;1;0;0;0;0;1;",
			"%a2 desfere um soco que erra as costelas de %d1, que rola e tenta se levantar. %a1 segura a cabeça na posição norte-sul... %a1 fecha uma chave forte no pescoço de %d2 e rola no chão fechando um triângulo de mão invertido!;%d2's fica azul e ele bate antes de dormir! Que movimento incrível de %a1! As pessoas estão batendo palmas!;%d2 rola também e sua cabeça escorrega para fora do pescoço. Ele se move para frente e ganha o controle lateral.;0;0;0;0;D'Arce Gator Roll;1;1;0;0;1;0;14;",
			"%d1 tenta se avançar em seu oponente...;%a1 esperava por isso e prende o braço de %d2 entre as pernas. Ele rola e o prende em uma chave cervical! %d2 parece estar com muita dor. Ele não consegue se libertar e bate! %d1 deve estar envergonhado por ter sido pego por um movimento tão extravagante.;%a1 tenta se esparramar para trás, mas é muito lento. %d2 sai correndo e fica de pé!;0;2;3;0;Manivela Twister Neck;1;1;0;0;0;0;1;",
			"%d1 tenta se engajar em seu oponente...;%a1 esperava por isso e prendeu a perna esquerda de %d2 entre as pernas. Ele rolou e o prendeu em uma chave de virilha! %d2 está em um sentindo muita dor agora, ele não consegue liberar as pernas e é forçado a bater!;%a1 tenta fazer o sprawl, mas ele é muito lento. %d2 se arrasta para fora e fica de pé!;15;2;3;0;Banana Split;1;1;0;0;0;0;1;",
			"%d1 tenta se engajar em seu oponente...;%a1 esperava por isso e pega a perna direita de %d2 entre as pernas. Ele rola e o trava em uma chave cervical! %d2 está em sentindo muita dor agora, ele não consegue liberar as pernas e é forçado a bater!;%a1 tenta fazer o sprawl, mas ele é muito lento. %d2 se afasta e fica de pé!;16;2;3;0;Banana Split;1;1;0;0;0;0;1;"));

	public static final ArrayList<String> standingFancySub1 = new ArrayList<String>(Arrays.asList(
			"%a2 pula e segura o braço de %d1 e tenta uma chave de braço voadora!;%a2 vai para o chão e bate sem saber o que estava acontecendo!;%d2 conse se defender se lança sobre %a1, caindo na posição de 100kg!;13;0;0;0;Submissão voando;1;1;0;0;0;0;14;",
			"%a2 pula e segura o braço de %d1 e tenta uma chave de braço voadora!;%a2 vai para o chão e bate sem saber o que estava acontecendo!;%d2 defende a chave e se lança sobre %a1, conseguindo cair ao lado do seu oponente!;14;0;0;0;Submissão voando;1;1;0;0;0;0;14;",
			"%a1 pula sobre seu oponente e tenta fechar um triângulo voador!;Movimento incrível de %a2! %d2 fica azul antes de bater! Isso acaba com uma finalização incrível;%d2 se adianta e pula para frente, lançando seu oponente contra o chão.;0;0;0;0;Triângulo voador cocke;1;1;0;0;0;3;0;",
			"%a1 trava o braço esquerdo de %d1 em uma kimura. Ele rola trazendo %d1 para o chão.;Ele prendeu e %d1 é forçado a bater!;Ele não consegue manter o controle sobre o corpo de %d1. %d1 se levanta rapidamente.;13;1;1;4;rolando kimura;1;1;-1;1;0;0;0;",
			"%a1 trava o braço direito de %d1 em uma kimura. Ele rola trazendo %d1 para o chão.;Ele prendeu e %d1 é forçado a bater!;Ele não consegue manter o controle sobre o corpo de %d1. %d1 se levanta rapidamente.;14;1;1;4;rolando kimura;1;1;-1;1;0;0;0;",
			"%a1 se joga no chão e pega a perna esquerda de %d1 em uma tentativa de chave de calcanhar!;%d1 foi surpreendido por aquele movimento e imediatamente bateu com a dor! Essa foi uma movimentação maluca!;a defesa de chave de calcanhar de%d1 está em dia e evita o tentativa audaciosa. Ele se levanta enquanto %a1 permanece no chão.;19;2;11;13;Flying Heel Hook;1;1;0;2;0;0;3;",
			"%a1 se joga no chão e pega a perna direita de %d1 em uma tentativa de uma chave calcanhar !;%d1 foi surpreendido por aquele movimento e imediatamente bateu com a dor! Essa foi uma tentativa maluca!;%d1 a defesa do chave de calcanhar está em dia e evita o tentativa audaciosa. Ele se levanta enquanto %a1 permanece no chão.;20;2;11;13;Flying Heel Hook;1;1;0;2;0;0;3;",
			"%a1 se vira descaradamente e rola para uma chave de joelho na perna esquerda de %d1... ;%d1 cai no chão e está muito agitado para liberar a perna a tempo. Ele estremece de dor e bate naquela chave de joelho habilidosa! Excelente BJJ!;%d1 evita que sua perna seja tomada e sai do perigo enquanto %a2 permanece no chão.;17;1;11;0;Roll Kneebar;1;1;0;1;0;0;3;",
			"%a1 se vira descaradamente e rola para uma chave de joelho na perna direita de %d1... ;%d1 cai no chão e está muito agitado para liberar a perna a tempo. Ele estremece de dor e bate naquela chave de joelho habilidosa! Excelente Jiu Jitsu!;%d1 evita que sua perna seja tomada e sai do perigo enquanto %a2 permanece no chão.;18;1;11;0;Roll Kneebar;1;1;0;1;0;0;3;",
			"%a1 faz um Imanari Roll em %d1 e a transforma em uma tentativa de chave de pé!;%d1 não conseguiu tirar a perna do caminho a tempo. Ele luta para se livrar, mas a dor é demais para suportar e ele bate ! Que habilidade de %a1! ;%d1 dá um passo para fora do perigo enquanto %a1 permanece no chão.;20;1;11;0;Diving Foot Lock;1;1;0;1;0;0;3 ;",
			"%a1 pula na perna esquerda de %d1 e a transforma em uma tentativa de chave de pé!;%d1 não conseguiu tirar a perna do caminho a tempo. Ele luta para se livrar, mas a dor é demais para suportar e ele bate!. ;%d1 dá um passo para fora do perigo enquanto %a1 permanece no chão.;19;1;11;0;Diving Foot Lock;1;1;0;1;0;0;3 ;",
			"%a1 segura o braço de %d1, pula no ar e envolve a perna em volta do ombro esquerdo em uma tentativa de omoplata voadora!;%d1 é forçado a cair no tatame com o braço torcido na chave de %a1. %a1 aplica pressão para o ombro de %d1 e o força a bater! Não acredito que ele conseguiu! Esse não é um movimento que você verá com frequência.;%a1 não consegue travar. %d1 sorri para reconhecer a tentativa audaciosa de finalização. %a1 permanece no chão com seu oponente de pé sobre ele.;13;1;11;0;Flying Omoplata;1;1;0;1;0;0;3;",
			"%a1 segura o braço de %d1, pula no ar e envolve a perna em volta do ombro direito em uma tentativa de omoplata voadora!;%d1 é forçado a cair no chão com o braço torcido na chave de %a1. %a1 aplica pressão para o ombro de %d1 e o força a bater! Não acredito que ele conseguiu! Esse não é um movimento que você verá com frequência.;%a1 não consegue encaixar. %d1 sorri para reconhecer a tentativa audaciosa de finalização. %a1 permanece no chão com seu oponente de pé sobre ele.;14;1;11;0;Flying Omoplata;1;1;0;1;0;0;3;"));

	public static final ArrayList<String> closedGuardFancySub1 = new ArrayList<String>(Arrays.asList(
			"%a2 muda uma guarda de borracha! Ele segura a cabeça de %d1 contra sua canela, envolvendo a outra "
					+ "perna sobre a cabeça de %d1!;%d2 deve bater! Incrível gogoplata!;%d2 luta e defende aquela tentativa de "
					+ "gogoplata!;0;0;10;8;Gogoplata;0;0;0;0;0;0;0;",
			"%a2 passa a perna em volta do ombro de %d1 e rola no chão!;%d1 sente dor ao bater! Uau! Dá para "
					+ "acreditar! %a1 venceu por omoplata! se joga por cima sobre o adversário, conquistando a posição de 100kg!"
					+ " Mas foi por pouco!;0;0;0;0;Omoplata;1;1;0;0;-1;0;14;",
			"%a2 tenta fechar uma chave de braço por baixo!;%d1 luta e se liberta, mas %a1 ainda segura o braço"
					+ " e rola e tenta agora uma chave de biceps! %d2 está batendo de dor!;%d2 sabe o que está por vir e se defende"
					+ " bem.;14;0;8;5;Bíceps deslizante;2;1;0;0;0;0;0;"));

	public static final ArrayList<String> thaiKnee1 = new ArrayList<String>(Arrays.asList(
			"%a2 tenta algumas joelhadas nas coxas de %d1 durante o clinche;Esses golpes parecem estar causando problemas para %d1;Nada com que se preocupar para %d2 que sabe como bloqueá-los;16;2;3;4;Joelhos;3;2;0;-5;0;12;12",
			"%a2 manda algumas joelhadas nas coxas de %d1 durante o clinch;Esses golpes parecem estar causando problemas para %d1;Nada com que se preocupar para %d2 que sabe como bloqueá-los;15;2;3;4;Joelhos;3;2;0;-5;0;12;12",
			"%a2 tenta lançar uma joelhada no corpo durante o clinche!;Golpe de raspão no abdômen de %d2!;%d2 empurra %a1 antes de ser atingido;11;3;1;2;Joelho;1;1;0;-1;0;12;1",
			"%a1 tenta pisões nos pés de %d2 enquanto está no clinche.;Esses golpes são mais irritantes do que prejudiciais para %d2;%d2 parece pouco afetado. %a1 deve procurar uma estratégia melhor se quiser alguma coisa dessa luta.;19;2;3;1;Batidas;2;2;0;-5;0;12;12"));

	public static final ArrayList<String> thaiKnee2 = new ArrayList<String>(Arrays.asList(
			"Várias joelhadas bem posicionadas de %a2!;Belos golpes nas costelas de %d2! Desempenho brilhante de %a1;%d1 é inteligente o suficiente para bloqueá-los!;10;0;3;1;Joelhadas;3;3;0;2;0;12;12",
			"%a2 agarra %d1 em um clinche e tenta dar uma joelhada no rosto dele!;Ele acerta! Bom golpe!;%d1 empurra %a1 e dá um passo para trás, afastando-se do clinche!;6;0;1;2;Joelhos;3;2;1;1;1;12;1",
			"%a2 pune as coxas de seu oponente com algumas joelhadas durante o clinch;Essas joelhadas estão acertando! %d2 deve fazer algo rápido!;%d2 segura seu oponente e bloqueia seus movimentos.;10;0;3;7;Joelhos;3;2;0;1;0;12;12",
			"Em uma disputa de força no clinche empurra %d2 de volta para o %holdSite, e %a2 agressiva com uma joelhada voadora;joelho VS rosto, que impacto!!! se não for o %holdSite %d2 seria jogado na arquibancada;%d2 afaste -se com confiança;0;2;1;2;Joelho contra o rosto;1;1;2;2;5;0;0;",
			"depois de medir a distância %a2 pule para frente com uma joelhada voadora;o joelho de %a1 acertou perfeitamente no peito de %d2, pela aparência de seu rosto deve ter doído muito;%d1 bloqueou com facilidade;9;2;1;3 ;Joelho ao peito;1;1;2;2;3;0;0;",
			"%a2 pula para frente com uma joelhada;forte impacto no rosto!!! aquele golpe manda %d1 para o chão;%d1 viu aquilo chegando e se levou do perigo;0;2;1;3;Joelho no rosto;1;1;2;2;5;2;0;",
			"%a2 investiu contra %d1 com uma joelhada voadora;%d1 foi atingido no peito e o impacto o mandou para o chão;%d1 viu aquilo vindo e bloqueou com facilidade;9;2;1;3;Joelho no peito ;1;1;2;2;3;2;0;",
			"%a2 tenta uma joelhada voadora em direção ao peito de %d1;que movimento o impacto envia %d2 para %holdSite;%d2 bloqueia e se afasta;9;2;1;3;Joelhada no peito;1;1;2;2;3;1;0;",
			"uma joelhada voadora de %a2 em direção ao rosto de %d1;acertou, que golpe! Com certeza isso dói, %d2 tem que ter mais cuidado agora;%d2 viu isso vindo e bloqueou;0;2;1;3;Joelhada para rosto;1;1;2;2;3;0;0;",
			"%a1 mede a distância com alguns socos e tenta uma joelhada rápida;%d2 foi atingido no abdômen, %d2 estava segurando seu abdômencom dor;%d2 bloqueia e dá um passo para trás;11;2;1;2;Joelho para abdômen;1;1;1;1;2;0;0;",
			"uma joelhada voadora de %a1 em direção a %d2 ;%d1 foi atingida no abdômen, golpe poderoso o manda para o chão;%a2 erra o alvo terrivelmente;11;2;1;3;Joelhada no adbomen;1;1;0;1;3;2;0;"));

	public static final ArrayList<String> thaiKnee3 = new ArrayList<String>(Arrays.asList(
			"Joelhadas brutais no rosto de %, joelhada seguidas no corpo de %a1!;Pegou! %d2 pode levar muito mais golpes assim!;%d2 não quer ser finalizado agora e se cobre!;5;- 2;3;1;Joelhos;6;4;4;2;2;12;12",
			"%a1 está controlando o clinch e lança uma joelhada cruel!;Golpe esmagador no rosto de %d2.;Ele estava mirando no rosto de %d2, mas seu movimento foi bloqueado;3;0;3;7;Joelhados;1;1;3 ;2;4;12;12",
			"Um, dois, três! %a2 não para de lançar aquelas joelhadas no clinch!;Joelhada devastadora que acerta o queixo de %d2! Aquele estalo foi ouvido por toda a arena! A multidão grita!;%d2 bloqueia e depois se afasta %a1!;8;0;1;2;Joelhos;3;1;2;2;5;12;1"));

	public static final ArrayList<String> grapplingKnee1 = new ArrayList<String>(Arrays.asList(
			"%a2 empurra seu oponente contra %holdSite e desfere um chute furioso nas costelas;Belo golpe!;%d2 empurra seu oponente para longe e circula em direção ao centro do %site.;0;0;0;0;Joelhada para as costelas;1;1;0;0;0;0;1;",
			"%a1 lança uma joelhada em direção à costela esquerda de %d1;Aquela joelhada acertou bem.;%d2 luta e bloqueia o impacto.;15;1;3;3;Joelho;1;1;0;-2;0;0;0;",
			"%a1 lança uma joelhada em direção à costela direita de %d1;Aquela joelhada acertou bem.;%d2 luta e bloqueia o impacto.;15;1;3;3;Joelho;1;1;0;-2;0;0;0;"));

	public static final ArrayList<String> grapplingKnee2 = new ArrayList<String>(Arrays.asList(
			"%a2 empurra seu oponente para baixo e lança uma joelhada pesada em sua cabeça em um movimento pouco ortodoxo...;Uau! Grande golpe no rosto de %d1!;%d2 bloqueia facilmente e procura um contra-ataque!;0;2;1;2;Joelho;1;1;1;1;1;1;1;",
			"%a1 lança uma joelhada enquanto segura %d2...;Aquele joelho atinge %d2 no abdômen;%d1 empurra %a1 e aquele joelho não vai a lugar nenhum!;11;1;2;1;Joelho;1;1;0;0;0;1;1;",
			"%a2 lança uma joelhada!;%a1 acerta %d2 com força logo abaixo das costelas!;%d2 bloqueia aquele joelho.;10;0;3;3;Joelho;1;1;0;0;0;0;0;",
			"%d2 tenta quebrar o clinche... %a1 lança uma ótima joelhada quando encontra um espaço estreito!;Impacto incrível! %d2 tropeça para trás e %a1 consegue uma queda incrível!;%d2 quebra o clinch e a joelhada passa perto mas não acerta!;10;2;1;4;Joelho;1;1;0;0;0;1;5;"));

	public static final ArrayList<String> punchesExchange = new ArrayList<String>(Arrays.asList(
			"%a1 e %d2 se envolvem em uma troca selvagem de socos!;%a1 está levando a melhor na troca enquanto acerta alguns golpes.;4;3;2;0;Ambos os lutadores estão se conectando e isso pode acabar em breve se qualquer um acertar um soco bem colocado.;4;3;3;3;Ambos os lutadores erraram terrivelmente.;3;0;3;0",
			"%a2 procura por ângulos enquanto lança alguns jabs que são contra-atacados pelos socos de %d1;%d2 está recebendo um ótimo combo de %a2.;4;3;1;0;%a2 mede quanto o queixo de %d2 aguenta com um uppercut enquanto %d2 acerta alguns grandes cruzados.;1;1;3;2;Ambos os lutadores estão se batendo descontroladamente!;2;0;3;0",
			"%a2 decide lançar alguns socos se muita força;%a1 leva o melhor de uma breve troca de socos.;3;2;1;0;%d2 lança alguns jabs que são respondidos por %a2 com um cruzado forte! Troca sólida !;2;2;1;1;Nada dessa troca. %a2 se move para trás e respira fundo.;2;0;3;0",
			"%a1 vai pra cima com um soco de direita enquanto %d1 pula para trás e solta jabs;%d2 parece cambaleante e %a1 corre para capitalizar com um monte de jabs e cruzados.;7;4;1;0;Aquele acerta, mas %d2 parece inalterado, contra-atacando com alguns socos. Grande troca aqui.;3;2;4;2;%a2 acerta apenas o ar e a troca subseqüente é infrutífera.;3;0;3;0",
			"Os dois trocam descontroladamente;%a2 está conectando com alguns socos;4;3;3;0;ambos acertando, mas sem muita força por trás dos golpes.;4;3;3;3;Ambos os lutadores estão errando terrivelmente.;3 ;0;3;0"));

	public static final ArrayList<String> endRound = new ArrayList<String>(Arrays.asList(
			"O árbitro separa os lutadores quando a campainha toca.",
			"A campainha soa, marcando o fim do round. O árbitro manda os lutadores irem para o corner deles.",
			"O árbitro interrompe a ação. O round acabou.",
			"%ref diz aos lutadores para irem para seus cantos, acabou o round.",
			"%ref separa os lutadores quando o round termina. Os lutadores apertam as mãos enquanto voltam para seus corners."));

	public static final ArrayList<String> cutman = new ArrayList<String>(Arrays
			.asList("O cutman está trabalhando no rosto de %a2.", "Parece que o cutman tem algum trabalho com %a1."));

	public static final ArrayList<String> moveBackward = new ArrayList<String>(
			Arrays.asList("%a2 parece hesitante como se fosse dar a espaço ao seu oponente.",
					"%a1 finge um movimento e se move lateralmente.",
					"%a1 está diminuindo um pouco o ritmo da luta e circula em torno de seu oponente."

			));

	public static final ArrayList<String> moveForward = new ArrayList<String>(
			Arrays.asList("%a1 avança procurando uma brecha na defesa do adversário.", "%a1 circula em torno de %d2",
					"%a1 fecha a distância com seu oponente querendo alguma ação."));

	public static final ArrayList<String> exhausted = new ArrayList<String>(Arrays.asList(
			"%a2 está com a mão abaixada e só quer que o round termine. Ele precisará de um treinamento de cardio melhor no futuro.",
			"%a2 está respirando com dificuldade. Ele está exausto e a luta vai ser muito complicada para ele daqui para frente.",
			"%a1 está visivelmente cansado. Você deve se perguntar o quanto ele treinou para esta luta.",
			"%a1 está cansando rapidamente.", "%a1 se cansou. Acho que não tem mais gasolina no tanque.",
			"%a2 deveria ter se controlado melhor. Parece que ele se cansou.",
			"Acho que %a1 precisa aprender a ter um ritmo melhor. Seu desempenho está caindo com o seu cansaço.",
			"%a1 é duro, mas a fadiga torna os homens covardes. Ele deve diminuir a velocidade e conservar a energia que lhe resta."));

	public static final ArrayList<String> tired = new ArrayList<String>(
			Arrays.asList("%a1 está tirando de boca aberta para respirar...",
					"%a2 dá um passo para trás e abaixa os braços enquanto respira pesadamente... Ele parece cansado.",
					"%a2 está esgotado... Que pena. O desempenho dele pode estar caindo a partir daqui."));

	public static final ArrayList<String> goodShape = new ArrayList<String>(
			Arrays.asList("%a1 parece fresco. Ele ainda pode ter muita gasolina em seu tanque.",
					"%a2 tem um cardio alto que o ajuda a fazer grandes performances.",
					"%a2 não mostra sinais de cansaço. Ele está em ótima forma."));

	public static final ArrayList<String> veryHurt = new ArrayList<String>(
			Arrays.asList("%a2 parece um morto-vivo... não sei quanto mais castigo ele pode receber.",
					"%d1 puniu muito %a2. Ele perdeu a confiança em vencer esta luta.",
					"%a2 está muito machucado. Você pode ver como ele está se movendo nos últimos momentos.",
					"%a1 parece um tanto abalado."));

	public static final ArrayList<String> hurt = new ArrayList<String>(
			Arrays.asList("%a2 está ferido... Ele deveria estar procurando evitar mais danos ou perderá esta luta.",
					"Boa surra %a1 recebeu.", "%a2 tem algumas contusões após algumas trocas com seu oponente.",
					"%a1 já teve dias melhores."));

	public static final ArrayList<String> healthy = new ArrayList<String>(
			Arrays.asList("%a2 parece estar em muito boa forma.",
					"À medida que a luta continua, parece que %a1 está levando a melhor.",
					"%a2 ainda está em boa forma. Ele com certeza treinou duro para esta luta."));

	public static final ArrayList<String> dangerousSub = new ArrayList<String>(Arrays.asList(
			"%a2 tem uma jiu jitsu Incrível. Ele pode terminar a luta a qualquer momento enquanto estiver no chão.",
			"Jiu Jitsu! Isso é o que deve estar passando pela cabeça de %d2 agora. Ninguém quer ficar muito tempo nessa posição com um finalizador como %a2",
			"Levante-se! Isso é o que os técnicos de %d2 estão gritando. %a1 é um mestre da finalização e pode terminar a luta a qualquer momento se você ficar com ele no chão.",
			"%a1 é um mago da finalização. Ele sabe mais de Jiu-Jitsu do que a maioria dos lutadores aprendeu.",
			"%a2 é um legitimo faixa preta em jiu jitsu. É uma honra vê-lo lutar no chão.",
			"Os fãs vão adorar agora. É sempre divertido ver %a1 trabalhar seu jogo de Jiu-Jitsu."));

	public static final ArrayList<String> dangerousStriker = new ArrayList<String>(Arrays.asList(
			"%a1 é um striker renomado. %d2 deve ter cuidado com as trocas se quiser entrar nessa luta.",
			"enquanto %a2 mantém a luta em pé, ele tem chance de ganhar.",
			"%a2 é um especialista em nocautes. %d2 deve estar ciente disso se não quiser nenhuma surpresa ruim esta noite.",
			"%a1 é um striker experiente. Ele quer atrair seu oponente para as trocas.",
			"Esse é o jogo de %a2. Ele pode finalizar seu oponente se essa luta continuar em pé.",
			"É um verdadeiro deleite para os torcedores ver %a1 trabalhar seu renomado jogo de trocação."));

	public static final ArrayList<String> dangerousGnP = new ArrayList<String>(Arrays.asList(
			"Não é uma posição desejável que %d2 esteja agora. %a1 é bem conhecido por seu seu ground and pound forte e implacável.",
			"%a2 é um daqueles homens capazes de te apagar com socos!",
			"os técnicos de %d2 estão gritando para seu lutador escapar do chão, pois %a2 pode terminar uma luta no chão com uma boa surra se você der a chance.",
			"Você pode ouvir a empolgação da torcida. %a1 pode encerrar a luta com seu ground and pound."));

	public static final ArrayList<String> dangerousClinch = new ArrayList<String>(Arrays.asList(
			"A arma preferida de %a1 são seus temíveis ataques de clinch. %d2 precisa pensar se tem o plano de jogo certo se pensou entrar nessa posição.",
			"Uma vez que %a2 é capaz de mantê-lo contra o %HoldSite em um clinch, você deve se preocupar.",
			"Os técnicos de %d2 estão preocupados com a luta se ele continuar no clinche com %a1.",
			"%a1 é um especialista em clinch. Esta é uma posição ruim para %d2.",
			"%a1 pode encerrar a luta a qualquer momento a partir do clinche. Você pode ouvir a multidão vibrar de expectativa. "));

	public static final ArrayList<String> bleeding = new ArrayList<String>(Arrays.asList("%a2 não para de sangrar.",
			"O rosto de %a1 está coberto de sangue. Ele pode estar tendo problemas para enxergar enquanto limpa o sangue dos olhos.",
			"Você pode ver o sangue de %a2 fazendo manchas no chão.",
			"%a1 continua a sangrar aquele corte. Pode estar afetando a visão dele.", "%a1 está sangrando muito!"));

	public static final ArrayList<String> crowdBoo = new ArrayList<String>(Arrays.asList(
			"As pessoas aqui estão vaiando os lutadores.",
			"Luta sem ação é desrespeito ao fãs. E eles estão vaiando abertamente os lutadores.",
			"O pessoal aqui do %venue está vaiando os lutadores. Eles deveriam aumentar a energia se quiserem uma reação melhor!",
			"A atmosfera feia aqui agora. Os fãs estão ficando inquietos devido à falta de ação.",
			"Os fãs sentem que estão assistindo a uma luta de Floyd Mayweather. Aí vêm as vaias."));

	public static final ArrayList<String> crowdSlightlyBoo = new ArrayList<String>(Arrays.asList(
			"Algumas pessoas aqui estão vaiando!", "Alguns fãs não gostam do que estão vendo e começam a vaiar!",
			"Você pode ouvir algumas vaias esparsas dos fãs.",
			"Isso está começando a se assemelhar a uma luta de Floyd Mayweather. Você pode ouvir as vaias começando."));

	public static final ArrayList<String> refStandUp = new ArrayList<String>(
			Arrays.asList("%ref já viu bastante passividade no chão e levanta os lutadores.",
					"O árbitro decide colocar os lutadores em pé, já que não havia muita ação no chão.",
					"%ref levanta os lutadores por falta de atividade."));

	public static final ArrayList<String> refStandUpOneFighter = new ArrayList<String>(
			Arrays.asList("%ref interrompe a luta para se levantar %a1. A luta recomeça com os dois lutadores em pé."));

	public static final ArrayList<String> staggered = new ArrayList<String>(
			Arrays.asList("%d2 parece um pouco grogue... seus movimentos não estão muito coordenados agora.",
					"Aquela punição de %a1 deixou %d2 atordoado! %a1 deveria tentar avançar agora e terminar isso!",
					"%d1 parece ferido! Ele tropeça para trás e é um alvo fácil para %a1!"));

	public static final ArrayList<String> oneStandUp = new ArrayList<String>(Arrays.asList("%a1 está de pé novamente.",
			"%a2 se levanta e está de pé agora.", "De volta ao começo! %a1 está de pé agora."));

	public static final ArrayList<String> bothStandUp = new ArrayList<String>(Arrays.asList(
			"Ambos os lutadores se levantaram e continuam a luta em pé. As pessoas que estão assistindo isso no local estão torcendo pelos lutadores.",
			"Ambos os lutadores continuam a luta em pé. Você pode ouvir como as pessoas concordam com essa decisão."));

	public static final ArrayList<String> towelThrow = new ArrayList<String>(Arrays.asList(
			"Os técnicos de %a1 pensam que seu homem já teve o apanhou bastente por hoje enquanto jogam a toalha dentro do %site. Isso é tudo pessoal!",
			"Espere um segundo! Parece que o técnicos de %a1 jogou a toalha. Que decepção. %a2 vai para trás e se senta. Isso acabou!"

	));

	public static final ArrayList<String> refRestartCenter = new ArrayList<String>(
			Arrays.asList("%ref interrompe a ação e reinicia a luta no centro.",
					"%ref pede aos lutadores que reiniciem a luta no centro.",
					"%ref interrompe a ação e os lutadores continuam do centro."));

	public static final ArrayList<String> firstRound = new ArrayList<String>(Arrays.asList(
			"O sino anuncia o primeiro round!", "%a2 e %d2 avançam quando o sino sinaliza o início da luta!",
			"A luta começa.", "%a1 e %d1 tocam as luvas no centro para começar essa luta!"));

	public static final ArrayList<String> upsetComment = new ArrayList<String>(
			Arrays.asList("Que grande surpresa! %a1 é o vencedor!",
					"Inacreditável! %d2 perdeu essa luta! Os sites de apostas vão explodir!",
					"E lá se vão meus 100R$! Que surpresa! %a1 é o vencedor!"));

	public static final ArrayList<String> winner = new ArrayList<String>(
			Arrays.asList("O vencedor é %a1 por %method no minuto %time_and_round"));

	public static final ArrayList<String> draw = new ArrayList<String>(
			Arrays.asList("A luta termina empatada entre %a1 e %d1."));

	public static final ArrayList<String> oneSided = new ArrayList<String>(
			Arrays.asList("Esta luta é muito unilateral. %a1 está acabando com %d1.",
					"Isso pode ser uma questão de estilos de jogo. %d1 não sabe como lutar contra %a1.",
					"%a1 está punindo %d2. Que desempenho absolutamente surpreendente!",
					"%d1 está sendo escolarizado hoje. Que desempenho horrível.",
					"%d1 está sendo educado... Aulas de MMA com o professor %a2.",
					"%a2 está acabando com %d2. É uma pena como esta luta não foi equilibrada.",
					"Que desempenho amador de %d2 esta noite. Seus fãs não ficarão satisfeitos.",
					"%d1 está ficando envergonhado aqui. %a2 parece ser demais para ele.",
					"%a2 construiu uma grande vantagem sobre %d2."));

	public static final ArrayList<String> evenMatch = new ArrayList<String>(Arrays.asList(
			"Boa luta entre esses dois guerreiros. Qualquer um pode ser o vencedor.",
			"Esta luta está equilibrada... Isso pode ir longe.",
			"%a2 e %d2 estão no mesmo nível hoje... Esta luta é muito interessante porque ninguém sabe quem vai ganhar.",
			"Nenhum lutador está claramente à frente agora.", "A luta ainda está em aberto neste momento.",
			"Você tem que dar crédito ao matchmaker por colocar uma luta tão equilibrada.",
			"Os matchmakers fizeram um ótimo trabalho ao emparelhar esses dois guerreiros."));

	public static final ArrayList<String> clinching = new ArrayList<String>(
			Arrays.asList("Ambos os lutadores estão agarrados em um clinche.", "Os lutadores estão no clinche."));

	public static final ArrayList<String> guards = new ArrayList<String>(
			Arrays.asList("%a2 está na costas de %d2", "%a1 está na montada sobre %d1",
					"%a1 está na guarda fechada sobre %d2", "%a1 está na posição de 100kg sobre %d1",
					"%a1 está na guarda aberta sobre %d2", "%a1 está na meia guarda sobre %d2",
					"%a2 está nas costas de %d2 com um gancho encaixado", "%a2 está na costas de %d2 com dois ganchos encaixados",
					"%a2 está de pé enquanto %d2 está no chão de costas", "%a2 está na guarda borboleta sobre %d1"));

	public static final ArrayList<String> roundWinnwer = new ArrayList<String>(Arrays.asList(
			"Este round é claramente de %a1.", "A round é para %a2, que caminha calmamente até seu corner.",
			"%a2 é o vencedor desse round.", "%a1 precisa estar confiante de que venceu esse round.",
			"Eu ficaria surpreso se os juízes não vissem esse round para %a2.",
			"Você tem que dar esse round para %a1."));

	public static final ArrayList<String> roundClose = new ArrayList<String>(
			Arrays.asList("Esse round é talvez do %a1, mas foi muito apertado.", "Esse foi um round apertado.",
					"Esse foi um round equilibrado na maior parte.",
					"Eu não acho que nenhum lutador fez mais do que o outro nesse round.",
					"Não posso dar vantagem para nenhum lutador nesse round.", "Esse round foi muito disputado.",
					"Eu não acho que nenhum dos lutadores levou a melhor sobre o oponente nesse round.",
					"Round apertado. Pode ir para qualquer lutador."));

	public static final ArrayList<String> odds1 = new ArrayList<String>(Arrays.asList(
			"E aí está! Eu colocaria meu dinheiro em %a1 hoje.", "%a1 é o favorito dos sites de apostas na internet.",
			"%a2 é o lutador que vai vencer hoje se prestarmos atenção nas apostas.",
			"%a1 é o melhor lutador na minha opinião. Seria uma surpresa se ele perdesse hoje.",
			"%d2 não é o favorito da mídia do MMA para vencer esta noite. Ele terá que fazer o seu melhor para conquistar essa vitória.",
			"%d1 vai ter uma luta difícil de acordo com o mercado de apostas."));

	public static final ArrayList<String> odds2 = new ArrayList<String>(
			Arrays.asList("Uma luta bastante justa hoje. Não sei dizer quem vai levantar o punho após a luta.",
					"As apostas dão uma chance igual para ambos os lutadores conseguirem a vitória hoje.",
					"É difícil dizer quem vai ganhar essa luta. A mídia especializada também não tem um favorito."));

	public static final ArrayList<String> vazdf66zio = new ArrayList<String>(Arrays.asList(

	));

}