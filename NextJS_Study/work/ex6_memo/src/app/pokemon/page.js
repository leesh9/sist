import { Card, CardContent } from "@mui/material"

export default function Pokemon(){
    let ar = [
        {name: "파이리", type: "불꽃", generation: 1, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 4, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/4.gif"},
        {name: "꼬부기", type: "물", generation: 1, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 7, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/7.gif"},
        {name: "이상해씨", type: "풀", generation: 1, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 1, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif"},
        {name: "브케인", type: "불꽃", generation: 2, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/155.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 155, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/155.gif"},
        {name: "리아코", type: "물", generation: 2, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/158.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 158, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/158.gif"},
        {name: "치코리타", type: "풀", generation: 2, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/152.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 152, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/152.gif"},
        {name: "아차모", type: "불꽃", generation: 3, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/255.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 255, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/255.gif"},
        {name: "물짱이", type: "물", generation: 3, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/258.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 258, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/258.gif"},
        {name: "나무지기", type: "풀", generation: 3, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/252.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 252, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/252.gif"},
        {name: "불꽃숭이", type: "불꽃", generation: 4, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/390.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 390, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/390.gif"},
        {name: "팽도리", type: "물", generation: 4, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/393.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 393, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/393.gif"},
        {name: "모부기", type: "풀", generation: 4, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/387.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 387, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/387.gif"},
        {name: "테푸피그", type: "불꽃", generation: 5, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/498.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 498, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/498.gif"},
        {name: "오샘눈", type: "물", generation: 5, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/501.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 501, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/501.gif"},
        {name: "주리비얀", type: "풀", generation: 5, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/495.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 495, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/495.gif"},
        {name: "푸호꼬", type: "불꽃", generation: 6, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/653.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 653, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/653.gif"},
        {name: "개구마르", type: "물", generation: 6, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/656.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 656, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/656.gif"},
        {name: "도치마론", type: "풀", generation: 6, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/650.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 650, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/650.gif"},
        {name: "냐오불", type: "불꽃", generation: 7, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/725.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 725, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/725.gif"},
        {name: "누리공", type: "물", generation: 7, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/728.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 728, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/728.gif"},
        {name: "모크나이퍼", type: "풀", generation: 7, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/722.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 722, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/722.gif"},
        {name: "염버니", type: "불꽃", generation: 8, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/813.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 813, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/813.gif"},
        {name: "울머기", type: "물", generation: 8, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/816.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 816, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/816.gif"},
        {name: "흥나숭", type: "풀", generation: 8, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/810.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 810, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/810.gif"},
        {name: "뜨아거", type: "불꽃", generation: 9, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/909.png", type_img: "https://i.namu.wiki/i/xTw1Dc_vjsfy6CZlfDSVoqQDF7oMHv6TsXbPhmJ0rH3PGrsI9qcxJtv-t8PbkqXZJB5YzgD011N1ZD40bivySQ.svg", dex: 909, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/909.gif"},
        {name: "꾸왁스", type: "물", generation: 9, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/912.png", type_img: "https://i.namu.wiki/i/kfRg1p4oK-8A11DDclR28KeVFJ_Mnc1RooPAnhbxi5X3sBScA1-UWliUtUSTf6jByQ892GZWZHtXoKyCq5SOvg.svg", dex: 912, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/912.gif"},
        {name: "나오하", type: "풀", generation: 9, image: "https://assets.pokemon.com/assets/cms2/img/pokedex/full/906.png", type_img: "https://i.namu.wiki/i/LmEE6oWElSim1Nfd2tCynkAae8-DKXy2V_TKD8b_DQUC3C-pOQbrsK5-lkLnwQMzbVntiHK_vFGZbuOrGFGyQg.svg", dex: 906, gif: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/906.gif"}
    ]
    return (
        <div className="list_bg">
            {ar.reduce((acc, item, index) => {
                if (index % 3 === 0) {
                    acc.push(
                            <CardContent sx={{display: 'flex', justifyContent: 'space-between'}}>
                                {ar.slice(index, index + 3).map((pokemon, subIndex) => (
                                    <div key={subIndex} className="list_item" style={{width: '33%'}}>
                                        <div style={{display: 'flex', flexDirection: 'column'}}>
                                            <div style={{display: 'flex', flexDirection: 'column'}}>
                                                <h4 className="list_item-h4">{pokemon.name}</h4>
                                                <p className="list_item-p" style={{marginRight: '10px'}}>타입: {pokemon.type}</p>
                                                <img src={pokemon.type_img} alt={pokemon.type} style={{width: '20px', height: '20px'}} />
                                                <p className="list_item-p">세대: {pokemon.generation}</p>
                                                <p className="list_item-p">도감 번호: {pokemon.dex}</p>
                                            </div>
                                            <img src={pokemon.gif} alt={`${pokemon.name} gif`} style={{width: '15%', height: 'auto'}} />
                                        </div>
                                        

                                        <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                                            <img src={pokemon.image} alt={pokemon.pokemon} style={{width: '85%', height: 'auto'}} />
                                            
                                        </div>
                                    </div>
                                ))}
                            </CardContent>
                    );
                }
                return acc;
            }, [])}
        </div>
    )
}