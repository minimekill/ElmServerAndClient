import Html exposing(Html,div,text,button)
import Html.Events exposing(onClick)
import Json.Decode as Decode
import Http


main =
  Html.beginnerProgram { model = model , view = view, update = update}


type Msg = GetNumber (Result Http.Error String) | UpNumber
lala : Http.Request String
lala =
  Http.getString "http://localhost:8080/SimpleServer/api/generic/number"
type alias Model = Int
model : Model
model =
  0


view : Model -> Html Msg
view model =
  div[]
  [text (toString model),button [onClick UpNumber] [text "MOAR!"]]



update : Msg -> Model -> Model
update msg model =
  case msg of
    GetNumber(Ok url) -> (model.number url,Cmd.none)
    UpNumber -> model + 1

type alias Somedata =
  {number : Int}

getFromServer : Cmd Msg
getFromServer =
  let
    url = "http://localhost:8080/SimpleServer/api/generic/number"
  in
    Http.send GetNumber(Http.get url decodeSomedata)

decodeSomedata : Decode.Decoder Int
decodeSomedata =
  Decode.at ["number"] Decode.int
