/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bl4ckskull666.landscost.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bl4ckSkull666
 */
public class LanguageLocale {
    private Map<String, String> _list = new HashMap<>();
    public LanguageLocale() {
        _list.put("af_za","Afrikaans");
        _list.put("ar_sa","Arabic");
        _list.put("ast_es","Asturian");
        _list.put("az_az","Azerbaijani");
        _list.put("ba_ru","Bashkir");
        _list.put("bar","Bavarian");
        _list.put("be_by","Belarusian");
        _list.put("bg_bg","Bulgarian");
        _list.put("br_fr","Breton");
        _list.put("brb","Brabantian");
        _list.put("bs_ba","Bosnian");
        _list.put("ca_es","Catalan");
        _list.put("cs_cz","Czech");
        _list.put("cy_gb","Welsh");
        _list.put("da_dk","Danish");
        _list.put("de_at","Austrian German");
        _list.put("de_ch","Swiss German");
        _list.put("de_de","German");
        _list.put("el_gr","Greek");
        _list.put("en_au","Australian English");
        _list.put("en_ca","Canadian English");
        _list.put("en_gb","British English");
        _list.put("en_nz","New Zealand English");
        _list.put("en_pt","Pirate English");
        _list.put("en_ud","British English (upside down)");
        _list.put("en_us","American English");
        _list.put("enp","English puristic");
        _list.put("enws","Early Modern English (Wikipedia)");
        _list.put("eo_uy","Esperanto");
        _list.put("es_ar","Argentinian Spanish");
        _list.put("es_cl","Chilean Spanish");
        _list.put("es_es","Spanish");
        _list.put("es_mx","Mexican Spanish");
        _list.put("es_uy","Uruguayan Spanish");
        _list.put("es_ve","Venezuelan Spanish");
        _list.put("esan","Andalusian");
        _list.put("et_ee","Estonian");
        _list.put("eu_es","Basque");
        _list.put("fa_ir","Persian");
        _list.put("fi_fi","Finnish");
        _list.put("fil_ph","Filipino");
        _list.put("fo_fo","Faroese");
        _list.put("fr_ca","Canadian French");
        _list.put("fr_fr","French");
        _list.put("fra_de","East Franconian");
        _list.put("fy_nl","Frisian");
        _list.put("ga_ie","Irish");
        _list.put("gd_gb","Scottish Gaelic");
        _list.put("gl_es","Galicia");
        _list.put("got_de","Gothic");
        _list.put("gv_im","Manx");
        _list.put("haw_us","Hawaiian");
        _list.put("he_il","Hebrew");
        _list.put("hr_hr","Hindi");
        _list.put("hr_hr","Croatian");
        _list.put("hu_hu","Hungarian");
        _list.put("hy_am","Armenian");
        _list.put("id_id","Indonesian");
        _list.put("ig_ng","Igbo");
        _list.put("io_en","Ido");
        _list.put("is_is","Icelandic");
        _list.put("isv","Interslavic");
        _list.put("it_it","Italian");
        _list.put("ja_jp","Japanese");
        _list.put("jbo_en","Lojban");
        _list.put("ka_ge","Georgian");
        _list.put("kab_kab","Kabyle");
        _list.put("kk_kz","Kazakh");
        _list.put("kn_in","Kannada");
        _list.put("ko_kr","Korean");
        _list.put("ksh","Kölsch/Ripuarian");
        _list.put("kw_gb","Cornish");
        _list.put("la_va","Latin");
        _list.put("lb_lu","Luxembourgish");
        _list.put("li_li","Limburgish");
        _list.put("lol_us","LOLCAT - The Kingdom of Cats (Web language)");
        _list.put("lt_lt","Lithuanian");
        _list.put("lv_lv","Latvian");
        _list.put("mi_nz","Māori");
        _list.put("mk_mk","Macedonian");
        _list.put("mn_mn","Mongolian");
        _list.put("moh_ca","Mohawk");
        _list.put("ms_my","Malay");
        _list.put("mt_mt","Maltese");
        _list.put("nb_no","Norwegian Bokmål");
        _list.put("nds_de","Low German");
        _list.put("nl_be","Flemish");
        _list.put("nl_nl","Dutch");
        _list.put("nn_no","Norwegian Nynorsk");
        _list.put("nuk","Nuu-chah-nulth");
        _list.put("oc_fr","Occitan");
        _list.put("oj_ca","Ojibwev");
        _list.put("ovd","Elfdalian");
        _list.put("pl_pl","Polish");
        _list.put("pt_br","Brazilian Portuguese");
        _list.put("pt_pt","Portuguese");
        _list.put("qya_aa","Quenya (Form of Elvish from LOTR)");
        _list.put("ro_ro","Romanian");
        _list.put("ru_ru","Russian");
        _list.put("scn","Sicilian");
        _list.put("sk_sk","Slovak");
        _list.put("sl_si","Slovenian");
        _list.put("sme","Northern Sami");
        _list.put("so_so","Somali");
        _list.put("sq_al","Albanian");
        _list.put("sr_sp","Serbian");
        _list.put("sv_se","Swedish");
        _list.put("swg","Allgovian German");
        _list.put("sxu","Upper Saxon German");
        _list.put("szl","Silesian");
        _list.put("ta_in","Tamil");
        _list.put("th_th","Thai");
        _list.put("tlh_aa","Klingon");
        _list.put("tt_ru","Turkish");
        _list.put("tt_ru","Tatar");
        _list.put("tzl_tzl","Talossan");
        _list.put("uk_ua","Ukrainian");
        _list.put("val_es","Valencian");
        _list.put("vec_it","Venetian");
        _list.put("vi_vn","Vietnamese");
        _list.put("yi_de","Yiddish");
        _list.put("yo_ng","Yoruba");
        _list.put("zh_cn","Chinese Simplified (China)");
        _list.put("zh_tw","Chinese Traditional (Taiwan)");
    }
    
    public boolean isLanguage(String lang) {
        return _list.containsKey(lang.toLowerCase());
    }
    
    public String getLanguageName(String lang) {
        if(isLanguage(lang))
            return _list.get(lang.toLowerCase());
        return "Not Listed yet";
    }
    
    public List<String> getLanguages() {
        List<String> list = new ArrayList<>();
        list.addAll(_list.keySet());
        return list;
    }
}
