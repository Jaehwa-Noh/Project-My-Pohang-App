//
//  CategoryAndRecommendRepository.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

struct CategoryAndRecommendRepository {
    let categories = [
        Category(category: CategoryType.coffeeShop),
        Category(category: CategoryType.restaurants),
        Category(category: CategoryType.kidFriendly),
        Category(category: CategoryType.parks),
        Category(category: CategoryType.shoppingCenters)
    ]
    
    let recommends = [
        Recommend(categoryType: CategoryType.coffeeShop, name: "가배원", location: "경상북도 포항시 북구 덕동문화길 12–2", information: "덕동문화마을 안에 있는 세월이 묻은 고택과 유형문화재, 울창한 소나무 숲에 숨겨진 명소, 한옥 카페 ‘가배원’에 들어서면 먼저 사랑스러운 고양이들이 눈인사로 맞아준다. 정자를 개조한 기둥과 대들보가 살아 있는 공간에 고풍스러운 소품과 사장님이 직접 그린 그림들의 조화를 이루는 평화롭고 고즈넉한 풍경 속에서 잠시 도심을 떠나 쉴 수 있는 곳이다. 메뉴는 커피와 기본 음료들도 좋지만, 5년 숙성된 오미자차, 생강차, 중국 운남성에서 공수한 100년 된 고수홍차와 시금치피자, 무화과 호밀빵 등 전통가옥에 어울리는 화려하지는 않지만 담백하고 깊은 자연의 맛을 추천한다. 마당을 품은 창가나 야외 테라스에 앉아 시원한 바람과 맑은 숲 공기를 마시며 즐기는 시간은 잠시 잠깐의 신선놀음이다. 테라스 끝에 계곡으로 이어지는 계단으로 내려가면 맑은 1급수가 1년 내내 흐르고, 봄에는 화사한 꽃이, 여름에는 청량한 숲이, 가을은 노란 은행나무들이 겨울엔 설경이 안내하는 자연 속에서 사람을 경계하지 않는 고양이들과 잠시 힐링할 수 있는 공간이다. 근처 포항전통문화체험관, 덕동민속전시관을 방문하고 마을 둘레길을 잠시 거닐어 보는 것도 추천한다. 연중무휴이나 요일별로 영업시간이 다르니 방문 전에 영업시간을 확인하는 게 좋다. 매주 변동 사항을 올린다.", picture: "recommend_1"),
        Recommend(categoryType: CategoryType.coffeeShop, name: "까멜리아인구룡포", location: "경상북도 포항시 남구 구룡포읍 구룡포길 133–1", information: "구룡포 근대문화역사 거리 내에 자리한 카페로, 드라마 <동백꽃 필 무렵>의 주요 배경이었던 ‘까멜리아’ 옆에 자리한다. 일본식 가옥의 빈티지한 분위기를 살린 까멜리아와 달리 이곳은 외관은 적산가옥의 형태를 띠지만 내부는 전혀 다른 풍경으로 눈길을 사로잡는다. 발리의 어느 리조트를 연상시키는 이국적인 인테리어가 마치 먼 나라로 여행을 떠나온 것처럼 기분 좋은 설렘을 느끼게 한다. 카페는 1층과 2층으로 나뉘는데, 1층에는 온통 초록빛 나무와 색색깔 꽃을 피운 화분들로 채워져 생기가 넘친다. 2층에는 야외 테라스도 마련돼 햇살 좋은 날 여유롭게 차 한 잔을 즐기기 좋다. 드라마 주인공의 이름을 딴 ‘동백이 빙수’도 구룡포만의 감성을 느끼기 좋은 메뉴다.", picture: "recommend_2"),
        Recommend(categoryType: CategoryType.coffeeShop, name: "오딘", location: "경상북도 포항시 북구 송라면 동해대로 3320 오딘", information: "포항 화진 해수욕장 인근에 위치한 3층 건물. 450평 규모의 베이커리 & 카페 오딘은 시원한 바다 조망과 화려하고 멋진 실내 인테리어로 이미 지역민과 젊은층 사이에서 분위기 좋은 카페로 인기를 끌고 있다. 그리스 신전을 모티브로 한 건물 벽면에는 하얀 조각상이 있으며 통창을 통해 파노라마처럼 펼쳐지는 파란 동해 바다는 이국적인 느낌을 제공하는 대형 오션뷰 카페이다. 크라샹과 소금빵, 직접 로스팅한 원두커피와 아보카도샷, 크림라떼, 계절 음료 등이 있으며 무엇보다 오딘은 100% 지역에서 생산한 농산물로 베이커리를 만들어 농민들도 돕고 지역 농산물 소비촉진도 하는 일석이조의 효과를 거두고 있다. 부추와 살구, 산딸기 등 지역에서 생산한 농산물을 이용해 베이커리를 만들다 보니 건강과 맛을 동시에 잡으면서 고품격 웰빙 베어커리 맛집으로 자리매김하고 있다. 지경항의 빨간등대와 몽돌 해변, 둘레길 산책로까지 지닌 장소로 잠시 일상에서 벗어나 여가를 즐길 수 있는 곳이다.", picture: "recommend_3"),
        Recommend(categoryType: CategoryType.coffeeShop, name: "카페라미닥", location: "경상북도 포항시 남구 상공로257번길 35–3 (송도동)", information: "카페라미닥은 갖가지 동물들과 교감할 수 있는 애견카페다. 내부는 지상 2층으로 이뤄졌다. 1층은 음료 등을 마실 수 있는 공간인데, 여우, 고양이, 강아지 등 여러 동물이 자유롭게 돌아다닌다. 2층에서는 라쿤과 미어캣을 구경할 수 있으며, 닥터피시 체험도 가능하다. 인근에 죽도시장, 영일대해수욕장 등 포항을 대표하는 관광지가 많다.", picture: "recommend_4"),
        Recommend(categoryType: CategoryType.coffeeShop, name: "러블랑", location: "경상북도 포항시 북구 송라면 동해대로 3310", information: "러블랑은 경북 포항시 북구 송라면에 있다. 카페 외부에는 포항 앞바다를 배경으로 좌석과 포토존이 갖춰져 있으며, 내부에서도 바다 풍광을 조망할 수 있다. 대표 메뉴는 카페러블랑이다. 이 밖에 아메리카노, 콜드브루, 카페라떼, 각종 디저트류 등을 판다. 특히 모든 베이커리 종류는 당일 생산과 당일 판매를 원칙으로 한다.", picture: "recommend_5"),
        Recommend(categoryType: CategoryType.restaurants, name: "오대양물회식당", location: "경상북도 포항시 북구 대신로 28–1", information: "오대양물회식당은 포항 북부시장에 있는 전통 고추장 물회로 유명한 맛집이다. 육수에 말아먹는 물회가 아닌 포항 전통 방식인 고추장 물회를 맛볼 수 있는 곳이다. 국물 없이 소면에 배와 고추장 양념과 얼음을 넣어 비벼 먹는다. 국물 없이도 시원하고 상쾌한 맛을 즐길 수 있다. 더불어 물회에 밑반찬으로 곁들여 나오는 밥식해 역시 별미이며, 함께 나오는 매운탕 또한 일품이다. 주요 메뉴인 물회 외에도 세꼬시, 무침회, 과메기 등을 맛볼 수 있다.", picture: "recommend_6"),
        Recommend(categoryType: CategoryType.restaurants, name: "환여횟집", location: "경상북도 포항시 북구 해안로 189–1", information: "포항 환여횟집은 방송에도 소개된 적 있는 물회 맛집이다. 1층은 물회, 2층은 회를 먹을 수 있도록 자리를 구분해 놓은 것이 특징이다. 대표 메뉴는 살얼음이 떠 있는 고추장 양념에 회, 야채를 부어 버무린 뒤 국수사리를 말아먹는 물회 국수이다. 물회를 주문하면 함께 나오는 매운탕 역시 얼큰하고 시원하다. 이 밖에도 맛볼 수 있는 메뉴로는 회덮밥, 전복죽, 모둠회 등이 있다.", picture: "recommend_7"),
        Recommend(categoryType: CategoryType.restaurants, name: "영일식육식당", location: "경상북도 포항시 북구 청하면 청하로192번길 5–8", information: "촬영을 위해 배우와 스태프들이 현지에 머무는 동안 애용했던 식당이다. 다양한 부위의 고기 메뉴가 주를 이루고 있는데 신선하고 질이 좋아 단골이 많다. 그중 가장 인기가 많은 돼지두루치기는 불에 올려 국물을 자작하게 졸여 먹으면 맛이 일품이다. 주문 시 기본 제공되는 밑반찬들도 깔끔하고 감칠맛이 있다.", picture: "recommend_8"),
        Recommend(categoryType: CategoryType.restaurants, name: "제일국수공장", location: "경상북도 포항시 남구 호미로221번길 19–2", information: "경상북도 향토 뿌리 기업으로 선정된 제일국수공장은 1969년 이순화 할머니가 제면기를 놓고 제면소를 차린 이래 50년이 넘는 역사를 지닌 가게이다. 현재 포항시에 하나 밖에 없는 제면소이자 국내에서는 유일하게 국수를 바닷바람으로 건조하여 만드는 곳으로 2012년 장남이 가업을 이어 받아 2대째 해풍국수의 전통의 맥을 잇는다. 이곳은 국수를 생산하고 판매 하는 곳이며 인터넷으로도 구입할 수 있다. 해풍국수의 맛을 보려면 제일국수공장에서 직영으로 운영하는 인근 ‘해풍국수 1호점’과 ‘자명점’에 방문하여 다양한 국수요리를 먹어보길 권한다. 차로 10분 거리에 드라마 \'동백꽃 필 무렵\' 촬영지와 30분 거리에는 포항 일출 명소 호미곶이 있다.", picture: "recommend_9"),
        Recommend(categoryType: CategoryType.restaurants, name: "평남식당", location: "경상북도 포항시 북구 죽도시장3길 9–16", information: "좋은 재료를 깔끔하게 사용하고 있다. 국물이 진하고 시원하며 곰탕에 수란이 들어가는 것이 특징이다.", picture: "recommend_10"),
        Recommend(categoryType: CategoryType.kidFriendly, name: "포항국제불빛축제", location: "경상북도 포항시 남구 해도동", information: "포항에서 펼쳐지는 대표적인 문화관광축제이자, 전국3대 불꽃축제인「포항국제불빛축제」는 POSCO야경과 동해안 풍경을 배경으로 국내 & 해외 유명불꽃팀이 참가하는 국제불꽃쇼가 불빛판타지를 선사한다.\n※ \'23-\'24 한국방문의 해 「K-컬처 관광이벤트 100선」 선정", picture: "recommend_11"),
        Recommend(categoryType: CategoryType.kidFriendly, name: "구룡포 피어라계단 미디어아트", location: "경상북도 포항시 남구 구룡포읍 호미로 277", information: "구룡포 미디어 아트는 구룡포 일본인 가옥거리 중앙계단(피어라 계단)에 새롭게 조성된 야간 볼거리다. 피어라 계단의 미디어 아트는 계단이라는 특수한 공간에 아나모픽(Anamorphic) 기법을 적용해 왜곡 없이 감상이 가능하며, 바닥에도 영상을 투사, 음향 효과까지 더해 깊은 몰입감을 관객들에게 선사한다. 포항의 아름다운 바다와 일출, 역동적인 포항 철강산업, 계단을 타고 흐르는 신비롭고 아름다운 계곡, 상상력을 자극하는 피어라 동심 등 4가지 주제로 이뤄져 있다. 상영시간은 약 10분간 진행된다.", picture: "recommend_12"),
        Recommend(categoryType: CategoryType.kidFriendly, name: "청하체리힐 체리농장", location: "경상북도 포항시 북구 청하면 화두길 32–45", information: "포항의 청하체리힐 농장에서는 6월부터 체리와 산딸기 수확 체험을 진행하며, 굿즈 만들기 체험과 농장에서 직접 만든 신선한 디저트들까지 다양한 경험으로 알찬 하루를 채울 수 있다. 체리 수확은 큐레이터의 친절한 설명과 함께 시작하며 설명을 듣는 재미도 쏠쏠하다. 농장에는 15 품종이 넘는 체리가 심겨 있으며 각각 맛도 모양도 조금씩 다르기 때문에 골라 먹는 재미가 있다. 수확 체험이 끝나면 다른 체험을 할 수 있는데, 가방에 그림을 그리거나 배지를 직접 만들어 달 수 있고 액자를 꾸미는 등 여러 가지 만들기 체험이 가능하다.", picture: "recommend_13"),
        Recommend(categoryType: CategoryType.kidFriendly, name: "영일민속박물관", location: "경상북도 포항시 북구 흥해읍 한동로 51", information: "영일민속박물관은 점차 사라져 가는 민속유물을 보존하고 이를 후세의 교육 자료로 활용하기 위해 건립된 박물관이다. 경상북도 영일군과 영일문화원이 공동으로 조선 말 흥해군 동헌이었던 제남헌을 수리하여 1983년 10월 29일 개관하였다. 이후 1985년 제2전시실을 신축하여, 1987년 6월 군 단위 민속박물관으로서는 국내 최초로 준 박물관으로 지정되었다. 영일민속박물관은 제1전시실, 제남헌, 제2전시실 등의 시설이 있으며, 야외에는 초가와 연자방아 등이 설치되어 있다. 전시된 민속유물로는 질그릇, 도자기 등의 토기류, 관혼상제 및 의관류, 베틀과 토기 항아리와 같은 생활용구류 그리고 제남헌과 골패, 비석과 같은 기타 유물이 있다. 이 외에도 지게와 도리깨, 절구, 그물 등 농어업 기계류와 조선건국사집과 칙명, 교지, 각종 시집 등 고서적류 역시 전시되어 있다.", picture: "recommend_14"),
        Recommend(categoryType: CategoryType.kidFriendly, name: "경상북도과학교육원", location: "경상북도 포항시 북구 우미길 93 (용흥동)", information: "경상북도과학교육원은 과학교육 진흥을 위해 교직원 및 학생들의 과학 활동 질적 향상을 목표로 1971년 4월 경상북도학생과학관으로 개관한 곳으로, 이후 경상북도과학교육원으로 개칭했다. 주제에 따라 나누어진 공간에서 전시와 체험을 통해 기초과학부터 첨단과학기술까지 직접 체험해 봄으로써 과학적 원리를 쉽게 이해, 학습할 수 있다. 경상북도과학교육원은 6층으로 이루어져 있다. 1층에는 시청각실, 과학체험마당, 어류 체험관 등이 있고 2층에는 천체투영실과 지구의 역사가 있다. 이 외에도 테크노타운, 생물 실험실, 지구과학실험실, 천체관측실 등이 있다. 폭넓은 주제로 구성된 전시를 통해 다양한 과학 원리와 현상을 직접 체험해 볼 수 있다. 주관하는 과학 탐구, 경진대회로는 발명품 경진대회, 청소년 과학체험, 발명 아이디어 그리기 대회 등이 있으며 이를 통해 학생들이 즐겁게 과학을 탐구할 수 있는 능력을 배양할 수 있도록 돕고 있다.", picture: "recommend_15"),
        Recommend(categoryType: CategoryType.parks, name: "포항 흥해향교 이팝나무 군락", location: "경상북도 포항시 북구 흥해읍 동해대로 1525 (흥해읍) 부근", information: "포항 흥해학교 이팝나무 군락은 고려 시대 충숙왕 때인 14세기 초 이곳에 흥해향교를 세우면서 기념으로 심은 나무에서 종자가 떨어져 번식한 것이다. 현재 34그루의 이팝나무와 상수리나무가 섞여서 군락을 이루고 있다. 이팝나무 군락은 경북향교재단의 소유이며 관리는 흥해향교에서 맡고 있다. 아름다운 경관뿐만 아니라 생물학적 자료의 가치 또한 높아 천연기념물로 지정되어 보호받고 있다. 이팝나무는 물푸레나무과에 속하는 낙엽교목으로, 중부 이남지방에서 많이 볼 수 있다. 꽃은 5~6월경에 피며, 희고 작은 꽃이 주로 가지 끝에 모여 달린다. 나무 전체가 흰 꽃으로 덮인 모습이 마치 흰쌀밥처럼 보인다고 하여 이팝나무라고 불린다. 그리고 이팝나무의 꽃이 많이 피고 적게 피는 것으로 그해 농사의 풍년과 흉년을 점칠 수 있다고 한다. 이팝나무는 물이 많은 곳에서 잘 자라는 식물이므로 비의 양이 적당하면 꽃이 활짝 피고, 부족하면 잘 피지 못한다. 물의 양은 벼농사와도 밀접하게 관련되어 있기 때문에 오랜 자연관찰의 결과로서 이와 같은 전설이 생긴 것으로 추정된다.", picture: "recommend_16"),
        Recommend(categoryType: CategoryType.parks, name: "포항 독수리바위", location: "경상북도 포항시 남구 호미곶면 구만길 226 (호미곶면) 부근", information: "독수리바위는 오랜 세월 동안 풍화작용으로 인해 조각된 바위의 형상이 독수리의 부리를 닮은 바위이다. 본래 이 지역은 풍파가 심하면 고기(청어)가 밀려나오는 경우가 허다하여 까꾸리(갈고리의 방언)로 끌었다는 뜻에서 지어진 지명으로 [까꾸리개]라고도 부른다. 독수리바위를 가까이서 조망할 수 있는 곳으로 내려가면 바닥에 독수리 트릭아트가 그려져 있고, 인근에는 갈매기 조형물도 있다. 호미곶의 땅끝인 이곳에서 서쪽으로 지는 석양의 노을을 바라보면 대흥산 너머 층층의 산과 시가지, 일렁이는 포스코 굴뚝이 보이는데 그 모습이 동양화를 연상케하는 절경이다.", picture: "recommend_17"),
        Recommend(categoryType: CategoryType.parks, name: "기청산식물원", location: "경상북도 포항시 북구 청하면 청하로175번길 50", information: "기청산식물원은 1969년 기청산농원에서 시작된 동해안 유일의 사립식물원이다. 한국의 토종 야생화와 수목을 비롯하여 교육적인 가치가 있는 각종 외래 식물 2,500여 종을 보유하고 있다. 기청산이란 명칭은 좋은 곡식만 골라내는 키를 뜻하는 [기]와 무릉도원과 유토피아를 상징하는 [청산]을 합성한 것으로, 좋은 식물과 사람이 모여 참세상을 만들고자 하는 염원을 담고 있다. 기청산식물원은 자생화원, 울릉식물관찰원, 용연지, 양치식물원 등 15개의 전시장으로 구성되어 있다. 전국 각지에서 자생하는 식물뿐만 아니라 울릉도에서 자생하는 멸종 위기종 식물, 희귀 특산식물 또한 만나볼 수 있다. 체험 프로그램으로는 숲해설, 반려 식물 심기, 양궁체험이 있다. 교육은 식물원 내 연구사들에 의해 진행된다. 숲해설은 초심자, 일반, 고급으로 나누어져 있고 반려 식물 심기 역시 초화류와 소관목으로 나누어져 있다.", picture: "recommend_18"),
        Recommend(categoryType: CategoryType.parks, name: "경상북도수목원", location: "경상북도 포항시 북구 죽장면 수목원로 647", information: "경상북도수목원은 평균 해발 650m에 위치한 고지대로 2,727ha의 국내 최대 면적을 가진 수목원이다. 경상북도 향토 고유 수종 및 국가 식물 유전 자원의 보전 및 연구, 도민의 정서 함양을 위한 자연친화적 생태교육 체험장 조성, 동해안권 관광지, 주변 식물원과 연계한 산림 생태 문화권 형성을 위하여 조성되었다. 독특한 생태를 가진 울릉도 식생을 재현한 울릉도 식물원과 고산식물원, 침엽수원 등 24개 소원으로 구성되어 있으며, 숲해설 전시관, 숲 체험학습관, 숲생태 관찰로 등의 체험시설과 자연체험학습장이 있다. 4월부터 11월에는 코스별 도장 깨기라는 식물 관련 퀴즈를 풀며 탐방을 하는 프로그램이 있어 자녀와 함께 재미있게 쉽게 식물을 관찰하며 산책할 수 있고, 보경사나 내연산 향로 봉으로 이어지는 등산 코스도 있어 남녀노소 누구나 즐겁게 방문할 수 있는 식물원이다.", picture: "recommend_19"),
        Recommend(categoryType: CategoryType.parks, name: "내연산보경사시립공원", location: "경상북도 포항시 북구 송라면 보경로 523", information: "경북 포항시 북구 송라면의 동북쪽에 위치한 내연산(710m)은 12개의 폭포를 간직하고 있는 태백산맥 줄기에 있는 산으로 그 경관이 아름다워 경북의 금강산 혹은 소금강이라 한다. 원래는 종남산이라 하였으나 신라진성여왕이 이 산에서 견훤의 난을 피한 뒤로는 내연산이라 부르게 되었으며 문수산(622m), 향로봉(930m), 삿갓봉(718m), 천령산(775m)등의 높은 준봉들로 둘러싸인 내연산 골짜기 청하골은 여느 심산유곡 못지않게 깊고 그윽하고 다양한 형태의 폭포와 소가 많기로 유명하다. 청하골의 12폭포 가운데 가장 경관이 빼어난 곳은 관음폭포(제 6폭포)와 연산폭포(제 7폭포)이다. 쌍폭인 관음폭포 주변에는 선일대, 신선대, 관음대, 월영대 등의 기암절벽이 장성처럼 둘러쳐저 있고, 폭포수가 만들어 놓은 못 옆에는 커다란 관음굴이 뚫려 있다. 이 굴 안쪽으로 들어가면 한쪽 입구를 가린 채 떨어지는 폭포수 줄기를 볼 수 있다. 관음폭포 위에 걸린 구름다리를 건너면 높이 30m, 길이 40m에 이르는 연산폭포의 위용이 눈에 들어온다. 이는 청하골에서 가장 규모가 큰 폭포인데, 학소대라는 깎아지른 절벽 아래로 커다란 물줄기가 쏟아지는 광경에는 탄성이 절로 나온다. 관음폭포 앞쪽 암벽의 벼룻길을 지나 다시 15분 가량 물길을 따라가면 또 하나의 폭포를 만나게 된다. 이 폭포는 숨겨져 있다고 해서 은폭이라 하는데, 가지런한 물줄기가 시퍼런 소로 떨어지는 모습이 사람들의 마음을 차분하게 해준다. 남쪽으로 2.5㎞ 떨어진 곳에는 유명한 보경사가 있다. 보경사는 신라 진평왕 때 일조대사가 인도에서 가져온 팔면경을 묻고 세웠다는 절로, 경내에는 고려 때 이송로가 지은 원진국사비(보물, 1963년 지정)와 포항 보경사 승탑(보물, 1965년 지정)·숙종어필 등이 있다. 보경사를 지나 물길과 나란히 이어지는 등산로를 1.5km쯤 오르면 제1폭포인 쌍생폭포가 나온다. 그리 우람하지는 않지만 두 물길이 양옆으로 나란히 떨어지는 모양이 단아하기 그지없다. 이 폭포를 지나면 잇따라 보현폭포(제2폭포), 삼보폭포(제3폭포), 잠룡폭포(제4폭포), 무봉폭포(제5폭포)가 나타난다. 등산코스로는 보경사를 출발하여 보현암~소금강전망대~은폭포삼거리~선일대~연산폭포~보경사 원점 회귀로 약 7.5km로 2시간 40분 소요된다. 이 코스는 내연산의 모든 명소를 돌아볼 수 있으며 1~7폭포 조망권으로 가장 아름다운 코스이다.", picture: "recommend_20"),
        Recommend(categoryType: CategoryType.shoppingCenters, name: "장기장 (4, 9일)", location: "경상북도 포항시 남구 장기면 임중리 368–1", information: "포항에서 남쪽으로 포항제철을 지나 청림 삼거리에서 929번 지방도를 따라 오천을 지나 감포방향으로 27km 지점 장기면 소재지 장기교에서 우회전하여 산서·방산 방면으로 약 100m 올라가면 장기시장이다. 5일장이 열리는 매달 4, 9, 14, 19, 24, 29일이면 장판이 노점상으로 이루어진다. 장기시장은 연안시장에서 어획된 수산물, 미역, 우렁쉥이, 넙치, 광어 등 신선한 해산물과 산지에서 생산된 산나물, 약초, 채소 및 잡곡일체를 저렴하게 구입할 수 있다. 또한 가축(소, 염소, 닭, 오리)의 소매도 이루어진다.", picture: "recommend_21"),
        Recommend(categoryType: CategoryType.shoppingCenters, name: "청하시장(공진시장)", location: "경상북도 포항시 북구 청하면 미남리 382–3", information: "활기 넘치는 오일장 극 중 배경인 가상의 마을인 공진. 공진 내에 자리한 공진시장의 실제 장소인 청하시장에는 실제로 1일과 6일에 \'청하오일장\'이 선다. 해산물부터 싱싱한 농산물, 직접 만든 먹거리까지 다양한 상품과 장을 보는 이들로 가득해 활기가 넘친다. 청하시장 곳곳에 \'갯마을차차차\' 촬영 세트 위치나 인근 관광지가 잘 표시되어 있는 안내판이 있으니 참고하자.", picture: "recommend_22"),
        Recommend(categoryType: CategoryType.shoppingCenters, name: "흥해장 (2, 7일)", location: "경상북도 포항시 북구 흥해로74번길 7–1", information: "1960년대 초부터 흥해시장이라는 명칭으로 상설 재래시장이 되었지만 여전히 5일장이 병행되며 그 명맥이 이어지고 있다. 오천장과 더불어 포항시 외곽지역에서 가장 큰 상권을 형성하고 있다. 달마다 2·7·12·17·22·27일에 장이 서는데 특이하게 4·9·14·19·24·29일에는 중간 장날인 샛장도 선다. 장날에는 시장터를 중심으로 시장 안쪽 길과 이면도로 구석구석까지 장터로 변한다. 포항시 흥해면 지역과 송라면·신광면·기계면·죽장면 등 인근 지역의 농민들이 손수 재배한 농산물을 비롯하여 해산물과 각종 공산품 등 모든 품목이 거래되는데 특히 곡강시금치, 오도돌김 및 돌미역, 칠포멸치, 남송배, 흥해안뜰쌀 등의 지역 특산품이 유명하다. 흥해장터 인근에는 영일민속박물관과 흥해 이팝나무군락(경상북도기념물), 칠포해수욕장, 내연산군립공원 등의 볼거리가 있다.", picture: "recommend_23"),
        Recommend(categoryType: CategoryType.shoppingCenters, name: "기계장 (1, 6일)", location: "경상북도 포항시 북구 기계면 기계로 575", information: "1960년대 초반부터 지금의 시장부지에 장옥들이 들어서면서 인근 영덕군 강구에서까지 싱싱한 활어 및 선어를 내다 팔고 있으며, 해안을 인접하고 있기 때문에 수산물이 활발히 거래되며 기타 채소류 등이 유통되고 있다. 5일장이 열리는 1, 6, 11, 16, 21, 26일이면 면내에 생산되는 농산물, 청과물, 농기구, 가축 및 잡화의 도·소매가 이루어지며, 내연산 주위에 분포한 산송이 군락은 지역 특화상품으로 개발가능성이 있다.", picture: "recommend_24"),
        Recommend(categoryType: CategoryType.shoppingCenters, name: "포항 죽도시장", location: "경상북도 포항시 북구 죽도시장13길 13 포항수산종합어시장", information: "포항 죽도시장은 50년전 갈대밭이 무성한 포항 내항의 늪지대의 노점상들이 들어서기 시작하여 형성되었다. 69년 10월 죽도시장 번영회가 정식 설립되었고. 현재 점포수가 1500여개에 달하는 경북 동해안 최대 규모를 자랑하는 재래시장이다. 최근 들어서는 대형 할인매장의 포항 진출로 어려움을 겪고 있지만, 죽도시장 상인들은 사이버 죽도시장을 개설하는 등 재출발을 다짐하고 있다.\n포항의 중심지인 오거리에서 동쪽으로 500m 지점에 동해안 최대의 상설시장인 죽도어시장이 있고 수산물 위판장내에 횟집 200여개가 밀집되어 있어 사계절 저렴한 가격으로 동해안의 싱싱한 회를 살 수 있으며, 인근 상가에서 초장 등 재료값만 내면 바로 먹을 수도 있다. 신선한 제철 해산물로 만든 포항물회와 통통한 전복이 통째로 들어간 전복죽이 전국적으로 유명하며, 특히 겨울철에는 포항의 명물인 과메기를 맛볼 수 있다.", picture: "recommend_25"),
    ]
    
}
