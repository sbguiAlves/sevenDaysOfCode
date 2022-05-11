package entities;

import services.Content;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class HTMLGenerator { //buscar jeitos de colocar um botao

    public void generate(PrintWriter writer, List<? extends Content> contentList, String company) {
        String div1 = """
                <html>
                	<head>
                	    <title>IMDB Movies and Series</title>
                		<meta charset="utf-8">
                		<meta name="viewport" content="width=device-width, initial-scale=1">
                		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
                		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
                		<style>
                		    h1 {text-align: center;}
                		    p {text-align: center;
                		        font-size: 18px;
                		        }
                		    body {
                                padding: 25px;
                                background-color: #2b2d3d;
                                color: white;
                                font-size: 25px;}
                		</style>
                	</head>
                	<body>
                	
                	<h1 class="text-center"> %s Movies and Series </h1>
                	    <div class="row">\040\040\040\040
                """;

        writer.println(String.format(div1, company));

        if (contentList != null) {
            for (Content content : contentList) {
                String div2 =
                        """
                                <div class="col-sm-3">
                                        <div class="card border-light text-white text-center bg-dark mb-2 my-2">
                                            <h4 class="card-header text-center">%s %s</h4>
                                            <div class="card-body text-center">
                                                <img class="card-img" src="%s" alt="%s">
                                                <p> IMDb Rating </p>
                                                <h4 class="card-text mt-2"> <span class="rate">%s </span></h4>
                                            </div>
                                    </div>
                                </div>
                                """;

                writer.println(String.format(div2, content.getTitle(), content.getYear(), content.getImage(), content.getTitle(), this.convertScaleToRatingStars(content.getRating())));
            }
        }

        writer.println(
                """
                    </div>
                </body>
            </html>
                        """);
    }

    private String convertScaleToRatingStars(String rating) //printa o numero de estrelas que precisa
    {

        float numPerScale;
        StringBuilder stars = new StringBuilder();

        if (rating.equals("N/A"))
            return "not rated";
        else
            numPerScale = (Float.parseFloat(rating));

        BigDecimal bd = new BigDecimal(numPerScale).setScale(0, RoundingMode.HALF_UP);

        for (int i = 0; i < bd.doubleValue(); i++) {
            stars.append("<i>★</i>");
        }
        return stars.toString();
    }
}
