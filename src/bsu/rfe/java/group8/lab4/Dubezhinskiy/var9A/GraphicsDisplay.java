package bsu.rfe.java.group8.lab4.Dubezhinskiy.var9A;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*;

public class GraphicsDisplay extends JPanel {
    private Double[][] graphicsData;
    // Флаговые переменные, задающие правила отображения графика
    private boolean showAxis = true;
    private boolean showMarkers = true;
    // Границы диапазона пространства, подлежащего отображению
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    // Используемый масштаб отображения
    private double scale;
    // Различные стили черчения линий
    private BasicStroke graphicsStroke;
    private BasicStroke axisStroke;
    private BasicStroke markerStroke;
    // Различные шрифты отображения надписей
    private Font axisFont;

    public GraphicsDisplay() {
        setBackground(Color.WHITE);
        // Сконструировать необходимые объекты, используемые в рисовании Перо для рисования графика
        graphicsStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{40, 10, 10, 10, 10, 10, 20, 10, 20}, 0.0f);
        // Перо для рисования осей координат
        axisStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        // Перо для рисования контуров маркеров
        markerStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 90.0f, null, 0.0f);
        // Шрифт для подписей осей координат
        axisFont = new Font("Serif", Font.BOLD, 35);
    }

    // Данный метод вызывается из обработчика элемента меню "Открыть файл с графиком"
    // главного окна приложения в случае успешной загрузки данных
    public void showGraphics(Double[][] graphicsData) {
        // Сохранить массив точек во внутреннем поле класса
        this.graphicsData = graphicsData;
        // Запросить перерисовку компонента, т.е. неявно вызвать paintComponent()
        repaint();
    }

    // Методы-модификаторы для изменения параметров отображения графика
    // Изменение любого параметра приводит к перерисовке области
    public void setShowAxis(boolean showAxis) {
        this.showAxis = showAxis;
        repaint();
    }

    public void setShowMarkers(boolean showMarkers) {
        this.showMarkers = showMarkers;
        repaint();
    }

    // Метод отображения всего компонента, содержащего график
    public void paintComponent(Graphics g)import javax.swing .*;
import java.awt .*;
import java.awt.font.FontRenderContext;
import java.awt.geom .*;

    public class GraphicsDisplay extends JPanel {
        private Double[][] graphicsData;
        // Флаговые переменные, задающие правила отображения графика
        private boolean showAxis = true;
        private boolean showMarkers = true;
        // Границы диапазона пространства, подлежащего отображению
        private double minX;
        private double maxX;
        private double minY;
        private double maxY;
        // Используемый масштаб отображения
        private double scale;
        // Различные стили черчения линий
        private BasicStroke graphicsStroke;
        private BasicStroke axisStroke;
        private BasicStroke markerStroke;
        // Различные шрифты отображения надписей
        private Font axisFont;

        public GraphicsDisplay() {
            setBackground(Color.WHITE);
            // Сконструировать необходимые объекты, используемые в рисовании Перо для рисования графика
            graphicsStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{40, 10, 10, 10, 10, 10, 20, 10, 20}, 0.0f);
            // Перо для рисования осей координат
            axisStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
            // Перо для рисования контуров маркеров
            markerStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 90.0f, null, 0.0f);
            // Шрифт для подписей осей координат
            axisFont = new Font("Serif", Font.BOLD, 35);
        }

        // Данный метод вызывается из обработчика элемента меню "Открыть файл с графиком"
        // главного окна приложения в случае успешной загрузки данных
        public void showGraphics(Double[][] graphicsData) {
            // Сохранить массив точек во внутреннем поле класса
            this.graphicsData = graphicsData;
            // Запросить перерисовку компонента, т.е. неявно вызвать paintComponent()
            repaint();
        }

        // Методы-модификаторы для изменения параметров отображения графика
        // Изменение любого параметра приводит к перерисовке области
        public void setShowAxis(boolean showAxis) {
            this.showAxis = showAxis;
            repaint();
        }

        public void setShowMarkers(boolean showMarkers) {
            this.showMarkers = showMarkers;
            repaint();
        }

        // Метод отображения всего компонента, содержащего график
        public void paintComponent(Graphics g) {
            // Шаг 1 - Вызвать метод предка для заливки области цветом заднего фона
            super.paintComponent(g);
            // Шаг 2 - Если данные графика не загружены - ничего не делать
            if (graphicsData == null || graphicsData.length == 0) {
                return;
            }
            // Шаг 3 - Определить минимальное и максимальное значения для координат X и Y\
            // Это необходимо для определения области пространства, подлежащей отображению
            minX = graphicsData[0][0];
            maxX = graphicsData[graphicsData.length - 1][0];
            minY = graphicsData[0][1];
            maxY = minY;
            // Найти минимальное и максимальное значение функции
            for (int i = 0; i < graphicsData.length; i++) {
                if (graphicsData[i][1] < minY) {
                    minY = graphicsData[i][1];
                }
                if (graphicsData[i][1] > maxY) {
                    maxY = graphicsData[i][1];
                }
            }
            //Шаг 4 - Определить (исходя из размеров окна) масштабы по осям X и Y - сколько пикселов
            double scaleX = getSize().getWidth() / (maxX - minX);
            double scaleY = getSize().getHeight() / (maxY - minY);
            // Шаг 5 - Чтобы изображение было неискажѐнным - масштаб должен быть одинаков Выбираем за основу минимальный
            scale = Math.min(scaleX, scaleY);
            // Шаг 6 - корректировка границ отображаемой области согласно выбранному масштабу
            if (scale == scaleX) {
                double yIncrement = (getSize().getHeight() / scale - (maxY - minY)) / 2;
                maxY += yIncrement;
                minY -= yIncrement;
            }
            if (scale == scaleY) {

                double xIncrement = (getSize().getWidth() / scale - (maxX - minX)) / 2;
                maxX += xIncrement;
                minX -= xIncrement;
            }
            // Шаг 7 - Сохранить текущие настройки холста
            Graphics2D canvas = (Graphics2D) g;
            Stroke oldStroke = canvas.getStroke();
            Color oldColor = canvas.getColor();
            Paint oldPaint = canvas.getPaint();
            Font oldFont = canvas.getFont();
            // Шаг 8 - В нужном порядке вызвать методы отображения элементов графика
            // Порядок вызова методов имеет значение, т.к. предыдущий рисунок будет затираться последующим
            // Первыми (если нужно) отрисовываются оси координат.
            if (showAxis) {
                paintAxis(canvas);
            }
            // Затем отображается сам график
            paintGraphics(canvas);
            // Затем (если нужно) отображаются маркеры точек, по которым строился график.
            if (showMarkers) {
                paintMarkers(canvas);
            }
            // Шаг 9 - Восстановить старые настройки холста
            canvas.setFont(oldFont);
            canvas.setPaint(oldPaint);
            canvas.setColor(oldColor);
            canvas.setStroke(oldStroke);
        }
    }
}