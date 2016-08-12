package com.linbin.mvpframework.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Information {

    /**
     * title : 黄历资讯
     * items : [{"title":"吃抗癌的食物，能不能有效防癌？","icon":"http://bos.tq.91.com/zxht/pic/20160612100441_60574.jpg","text":"时不常地总能在网上或朋友圈中看到\u201c抗癌食物排行榜\u201d、\u201c防癌必吃的N大食物\u201d等防癌\u201c秘笈\u201d。","stat":{"label":"8_吃抗癌的食物，能不能有效防癌？"},"act":"http://tq.91.com/api/?act=502&format=html&id=37935&cAct=4&model=season&infoTag=8&title=%E5%90%83%E6%8A%97%E7%99%8C%E7%9A%84%E9%A3%9F%E7%89%A9%EF%BC%8C%E8%83%BD%E4%B8%8D%E8%83%BD%E6%9C%89%E6%95%88%E9%98%B2%E7%99%8C%EF%BC%9F&key=9c10889371e7d46a0f8736890e359990&shareType=4&pid="}]
     */

    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public static class Items {
        private String title;
        /**
         * title : 吃抗癌的食物，能不能有效防癌？
         * icon : http://bos.tq.91.com/zxht/pic/20160612100441_60574.jpg
         * text : 时不常地总能在网上或朋友圈中看到“抗癌食物排行榜”、“防癌必吃的N大食物”等防癌“秘笈”。
         * stat : {"label":"8_吃抗癌的食物，能不能有效防癌？"}
         * act : http://tq.91.com/api/?act=502&format=html&id=37935&cAct=4&model=season&infoTag=8&title=%E5%90%83%E6%8A%97%E7%99%8C%E7%9A%84%E9%A3%9F%E7%89%A9%EF%BC%8C%E8%83%BD%E4%B8%8D%E8%83%BD%E6%9C%89%E6%95%88%E9%98%B2%E7%99%8C%EF%BC%9F&key=9c10889371e7d46a0f8736890e359990&shareType=4&pid=
         */

        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String title;
            private String icon;
            private String text;
            /**
             * label : 8_吃抗癌的食物，能不能有效防癌？
             */

            private StatBean stat;
            private String act;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public StatBean getStat() {
                return stat;
            }

            public void setStat(StatBean stat) {
                this.stat = stat;
            }

            public String getAct() {
                return act;
            }

            public void setAct(String act) {
                this.act = act;
            }

            public static class StatBean {
                private String label;

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }
            }
        }
    }
}